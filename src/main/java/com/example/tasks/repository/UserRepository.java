package com.example.tasks.repository;

import com.example.tasks.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> { }
