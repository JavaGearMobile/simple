package com.example.tasks.enums;

public enum EUserError {
    UserAlreadyExists("Пользователь с таким именем уже существует!"),
    UserCreated("Пользователь успешно создан!"),
    UserCreatedWithError("При создании пользователя произошла ошибка!");

    private String message;

    EUserError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
