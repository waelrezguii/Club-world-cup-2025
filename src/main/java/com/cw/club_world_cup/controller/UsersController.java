package com.cw.club_world_cup.controller;

import com.cw.club_world_cup.model.Users;
import com.cw.club_world_cup.repository.UsersRepository;
import com.cw.club_world_cup.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")

public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users loginInfos) {
        Optional<Users> user = usersService.findByEmailAndMdp(loginInfos.getEmail(), loginInfos.getMdp());
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Users newUser) {
        Optional<Users> existingUser = usersService.findByEmail(newUser.getEmail());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
        }

        Users savedUser = usersService.save(newUser);
        System.out.println("Registered User: " + savedUser);  // Debug statement
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
