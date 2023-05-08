package com.example.tasks.controllers;

import com.example.tasks.entity.TaskEntity;
import com.example.tasks.enums.ETaskEnum;
import com.example.tasks.services.TaskService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity createTask(@RequestBody TaskEntity task, @RequestParam Long id) {
        try {
            return ResponseEntity.ok(taskService.createTask(task, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ETaskEnum.TaskError.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity completeTask(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(taskService.completeTask(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ETaskEnum.TaskError.getMessage());
        }
    }
}
