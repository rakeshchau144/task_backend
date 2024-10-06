package com.example.task.controller;

import com.example.task.entity.Task;
import com.example.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add/task")
    public ResponseEntity<?> addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @GetMapping("get/all/task")
    public ResponseEntity<?> getAllTask(){
        return taskService.getAllTask();
    }
    @GetMapping("/get/task/by/id")
    public ResponseEntity<?> getTaskById(@RequestParam Integer id){
        return taskService.getTaskById(id);
    }
    @PutMapping("/update/task")
    public ResponseEntity<?> updateTaskById(@RequestParam Integer id, @RequestParam String name){
        return taskService.updateTaskById(id,name);
    }
    @DeleteMapping("/delete/task/by/id")
    public ResponseEntity<?> deleteTaskById(@RequestParam Integer id){
        return taskService.deleteTaskById(id);
    }
}
