package com.example.tasks.enums;

public enum ETaskEnum {
    TaskError("Произошла ошибка создания задачи");

    private String message;

    ETaskEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
