package com.example.tasks.services;

import com.example.tasks.entity.UserEntity;
import com.example.tasks.enums.EUserError;
import com.example.tasks.exceptions.UserAlreadyExistsException;
import com.example.tasks.exceptions.UserNotFoundException;
import com.example.tasks.models.UserModel;
import com.example.tasks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Создание нового пользователя
     * @param userEntity Сущность пользователя в базе данных
     * @return
     * @throws UserAlreadyExistsException
     */
    public UserEntity createUser(UserEntity userEntity) throws UserAlreadyExistsException {
        if (userRepository.findByUsername(userEntity.getUsername()) != null) {
            throw new UserAlreadyExistsException(EUserError.UserAlreadyExists.getMessage());
        }
        return userRepository.save(userEntity);
    }

    /**
     * Нахождение пользователя по его идентификатору
     * @param id Идентификатор пользователя
     * @return
     * @throws UserNotFoundException
     */
    public UserModel getUniqueUser(Long id) throws UserNotFoundException {
        UserEntity findUser = userRepository.findById(id).get();
        if (findUser == null) {
            throw new UserNotFoundException(EUserError.UserNotFound.getMessage());
        } else {
            return UserModel.getModel(findUser);
        }
    }

    public Long removeUser(Long id) throws UserNotFoundException {
        UserEntity findUser = userRepository.findById(id).get();
        if (findUser == null) {
            throw new UserNotFoundException(EUserError.UserNotFound.getMessage());
        } else {
            userRepository.deleteById(id);
            return id;
        }
    }
}
