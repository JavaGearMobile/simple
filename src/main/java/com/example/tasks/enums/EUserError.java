package com.example.tasks.enums;

public enum EUserError {
    UserAlreadyExists("Пользователь с таким именем уже существует!"),
    UserCreated("Пользователь успешно создан!"),
    UserNotFound("Пользователь с таким идентификатором не найден!"),
    UserNotFounding("Ошибка при поиске пользователя"),
    UserRemoved("Пользователь успешно удален"),
    UserCreatedWithError("При создании пользователя произошла ошибка!");

    private String message;

    EUserError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
