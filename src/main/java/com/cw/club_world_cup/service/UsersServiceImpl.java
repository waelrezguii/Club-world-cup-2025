package com.cw.club_world_cup.service;

import com.cw.club_world_cup.model.Users;
import com.cw.club_world_cup.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Override
    public Optional<Users> findByEmailAndMdp(String email, String mdp) {
        Optional<Users> user = usersRepository.findByEmail(email);
        if (user.isPresent()) {
            boolean matches = user.get().verifyPassword(mdp, passwordEncoder);
            System.out.println("Password matches: " + matches);  // Debug statement
            if (matches) {
                return user;
            }
        }
        return Optional.empty();
    }

    @Override
    public Users save(Users user) {
        user.encodePassword(passwordEncoder);
        System.out.println("Encoded Password: " + user.getMdp());  // Debug statement
        return usersRepository.save(user);
    }
}
