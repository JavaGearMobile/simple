package com.example.tasks.repository;

import com.example.tasks.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<TaskEntity, Long> { }
