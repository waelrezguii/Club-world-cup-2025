package com.cw.club_world_cup.repository;

import com.cw.club_world_cup.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,String> {
    Optional<Users> findByEmail(String email);
}
