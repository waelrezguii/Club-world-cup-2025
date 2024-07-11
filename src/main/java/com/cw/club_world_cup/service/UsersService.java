package com.cw.club_world_cup.service;

import com.cw.club_world_cup.model.Users;

import java.util.Optional;

public interface UsersService {
    Optional<Users> findByEmail(String email);
    Optional<Users> findByEmailAndMdp(String email, String password);
    Users save(Users user);
}
