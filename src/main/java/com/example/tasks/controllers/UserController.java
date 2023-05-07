package com.example.tasks.controllers;

import com.example.tasks.entity.UserEntity;
import com.example.tasks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public ResponseEntity getAllUsers() {
        try {
            return ResponseEntity.ok("Get all users");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error while creating user");
        }
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserEntity userEntity) {
        try {
            userRepository.save(userEntity);
            return ResponseEntity.ok("User created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
