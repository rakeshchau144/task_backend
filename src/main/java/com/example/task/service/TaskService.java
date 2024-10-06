package com.example.task.service;

import com.example.task.entity.Task;
import com.example.task.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;

    public ResponseEntity<?> addTask(Task task) {
        try{
            Task task1 = taskRepo.save(task);
            return new ResponseEntity<>(task1, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<?> getAllTask() {
        try {
            return new ResponseEntity<>(taskRepo.findAll(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getTaskById(Integer id) {
        try{
            Optional<Task> task = taskRepo.findById(id);
            if(task.isPresent()){
                return new ResponseEntity<>(task.get(),HttpStatus.OK);
            }
            return new ResponseEntity<>("Invalid id",HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteTaskById(Integer id) {
        try{
            Optional<Task> task = taskRepo.findById(id);
            if(task.isPresent()){
                taskRepo.delete(task.get());
                return new ResponseEntity<>("Task deleted",HttpStatus.OK);
            }
            return new ResponseEntity<>("Invalid id",HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<?> updateTaskById(Integer id, String name) {
        try{
            Optional<Task> task = taskRepo.findById(id);
            if(task.isPresent()){
                Task task1 = new Task();
                task1=task.get();
                if(name!=null){
                    task1.setTaskName(name);
                }
                taskRepo.save(task1);
                return new ResponseEntity<>("Task Updated",HttpStatus.OK);
            }
            return new ResponseEntity<>("Invalid id",HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
        }
    }
}
