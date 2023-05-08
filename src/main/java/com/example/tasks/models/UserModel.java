package com.example.tasks.models;

import com.example.tasks.entity.UserEntity;
import lombok.Data;

@Data
public class UserModel {
    private Long id;
    private String username;

    public static UserModel getModel(UserEntity userEntity) {
        UserModel userModel = new UserModel();
        userModel.setId(userEntity.getId());
        userModel.setUsername(userEntity.getUsername());

        return userModel;
    }
}
