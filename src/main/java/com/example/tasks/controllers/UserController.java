package com.example.tasks.controllers;

import com.example.tasks.entity.UserEntity;
import com.example.tasks.enums.EUserError;
import com.example.tasks.exceptions.UserAlreadyExistsException;
import com.example.tasks.exceptions.UserNotFoundException;
import com.example.tasks.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity getUniqueUser(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(userService.getUniqueUser(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(EUserError.UserNotFounding.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserEntity userEntity) {
        try {
            userService.createUser(userEntity);
            return ResponseEntity.ok(EUserError.UserCreated.getMessage());
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(EUserError.UserCreatedWithError.getMessage());
        }
    }
}
