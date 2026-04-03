package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Task;
import com.example.demo.Services.TaskService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) {
    Task addTask=taskService.addTask(task);
        if(addTask == null) {
            throw new IllegalArgumentException("Task not added, try again");
        }
        return addTask;
    }
    @GetMapping("/getAll")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @GetMapping("/findById")
    public Optional<Task> findTaskById(@RequestParam String id) {
        
        return taskService.findTaskById(id);
    }
   @DeleteMapping("/delete")
    public String deleteTask(@RequestParam String id) {
         Optional<Task> task = taskService.findTaskById(id);
        if (task == null) {
            return "Task not found with ID: " + id;
        }
        taskService.deleteTask(id);
        return "Task deleted successfully with ID: " + id;
    }
    // @PutMapping("/markCompleted")
    //  public void markTaskAsCompleted(@RequestParam String id) {
    //     Optional<Task> task = taskService.findTaskById(id);
    //     if (task == null) {
    //         throw new IllegalArgumentException("Task not found with ID: " + id);
    //     }
    //     taskService.markTaskAsCompleted(id);
    // }
    
}
