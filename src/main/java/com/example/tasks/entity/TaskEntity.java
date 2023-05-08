package com.example.tasks.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @Column(nullable = false)
    private Boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
