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
            if (userRepository.findByUsername(userEntity.getUsername()) != null) {
                return ResponseEntity.badRequest().body("Пользователь с таким именем уже существует!");
            } else {
                userRepository.save(userEntity);
                return ResponseEntity.ok("Пользователь успешно создан!");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("При создании пользователя произошла ошибка!");
        }
    }
}
