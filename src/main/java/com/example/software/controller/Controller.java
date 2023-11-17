package com.example.software.controller;

import com.example.software.bean.Official;
import com.example.software.bean.Task;
import com.example.software.mapper.TaskMapper;
import com.example.software.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    private TaskService taskService;
    @GetMapping("/all")
    public List<Task> getAllTasks() {
            List all=taskMapper.getAllTasks();
            return all;
    }

    @GetMapping("/allofficial")
    public List<Official> getAllofficial() {
        List allofficial=taskMapper.getAllofficial();
        return allofficial;
    }

    @DeleteMapping("/deleteTask")
    public ResponseEntity<String> deleteTask(@RequestBody Task task) {
        try {
            taskService.deleteTask(task);
            return new ResponseEntity<>("任务删除成功", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("删除任务时出错: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/updateTask")
    public ResponseEntity<String> updateTask(@RequestBody Task editedTask) {
        try {
            // 调用Service层的方法更新任务信息
            taskService.updateTask(editedTask);
            return ResponseEntity.ok("Task updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating task: " + e.getMessage());
        }
    }
    @PostMapping("/addTask")
    public ResponseEntity<String> addTask(@RequestBody Task temporaryTaskForm) {
        try {
            // 调用Service层的方法更新任务信息
            taskMapper.addTask(temporaryTaskForm);
            return ResponseEntity.ok("Task updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating task: " + e.getMessage());
        }
    }
}
