package com.example.tasks.controllers;

import com.example.tasks.entity.UserEntity;
import com.example.tasks.exceptions.UserAlreadyExistsException;
import com.example.tasks.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

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
            userService.createUser(userEntity);
            return ResponseEntity.ok("Пользователь успешно создан!");
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("При создании пользователя произошла ошибка!");
        }
    }
}
