package com.example.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.Service.Housekeeping.HKservice;
import com.example.backend.model.housekeeping.Task;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/housekeeping")
public class HousekeepingController {

    @Autowired
    HKservice hKservice;

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return hKservice.getTasks();

    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return hKservice.create(task);

    }

    @PutMapping("/tasks/{task_name}")
    public Task updateTask(@PathVariable String task_name, @RequestBody Task task) {
        return hKservice.updateTask(task_name, task);

    }
}
