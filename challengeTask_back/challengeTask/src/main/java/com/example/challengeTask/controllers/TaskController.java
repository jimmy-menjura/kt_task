package com.example.challengeTask.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.challengeTask.models.Task;
import com.example.challengeTask.services.TaskServices;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	TaskServices taskService;

    @PostMapping("/saveTask")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
    	List<Task> dataList = taskService.getAllTask();
    	dataList.add(task);
    	taskService.saveTask(dataList);
        return ResponseEntity.ok(task);
    }
    
    @GetMapping("/getTask")
    public ResponseEntity<List<Task>> getAllTask() {
        return ResponseEntity.ok(taskService.getAllTask());
    }
    
    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<Boolean> getAllTask(@PathVariable String id) {
        return ResponseEntity.ok(taskService.deleteAllTask(id));
    }
    
}
