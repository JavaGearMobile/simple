package com.example.tasks.services;

import com.example.tasks.entity.TaskEntity;
import com.example.tasks.entity.UserEntity;
import com.example.tasks.repository.TaskRepository;
import com.example.tasks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Создание новой задачи пользователя
     * @param task Задача пользователя
     * @param id Идентификатор пользователя
     * @return
     */
    public TaskEntity createTask(TaskEntity task, Long id) {
        UserEntity user = userRepository.findById(id).get();
        task.setUser(user);

        return taskRepository.save(task);
    }

    /**
     * Пометка задачи пользователя
     * @param id Идентификатор задачи
     * @return
     */
    public TaskEntity completeTask(Long id) {
        TaskEntity task = taskRepository.findById(id).get();
        task.setCompleted(!task.getCompleted());

        return taskRepository.save(task);
    }
}
