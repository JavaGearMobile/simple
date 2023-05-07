package com.example.tasks.services;

import com.example.tasks.entity.UserEntity;
import com.example.tasks.exceptions.UserAlreadyExistsException;
import com.example.tasks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity userEntity) throws UserAlreadyExistsException {
        if (userRepository.findByUsername(userEntity.getUsername()) != null) {
            throw new UserAlreadyExistsException("Пользователь с таким именем уже существует!");
        }
        return userRepository.save(userEntity);
    }
}
