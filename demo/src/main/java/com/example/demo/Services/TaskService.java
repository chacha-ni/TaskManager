package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Models.Task;
import com.example.demo.Repositories.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final IdGenerator idGenerator;

// public TaskService(@Autowired TaskRepository taskRepository,@Autowired IdGenerator idGenerator) {
//     this.taskRepository = taskRepository;
//     this.idGenerator = idGenerator;
// }

    public Task addTask(Task task) {
        if (task == null) 
         throw new IllegalArgumentException("Task cannot be null");
        task.setId(idGenerator.getNextId());
          task.setCompleted(false);
        if (task.getName() == null || task.getName().isEmpty()) 
         throw new IllegalArgumentException("Task name cannot be null or empty");
        return taskRepository.addTask(task);
    }
    public List<Task> getAllTasks() {
        List<Task> tasks = taskRepository.getAllTasks();
        if (tasks == null || tasks.isEmpty()) {
            return new ArrayList<>(); 
        }
        return tasks;
    }
    public Optional<Task> findTaskById(Long id) {
        if (id == null || id <= 0) 
         throw new IllegalArgumentException("Invalid task ID");
       Optional<Task> taskOpt = taskRepository.findTaskById(id);
       if (taskOpt.isPresent()) {
        return taskOpt;
    }
     throw new IllegalArgumentException("Task not found with ID: " + id);
    }


    public boolean deleteTask(Long id) {
        if (id == null || id <= 0) 
         throw new IllegalArgumentException("Invalid task ID");
        return taskRepository.deleteTask(id);
    }
   public void markTaskAsCompleted(Long id) {
        if (id == null || id <= 0) 
         throw new IllegalArgumentException("Invalid task ID");
        taskRepository.markTaskAsCompleted(id);
    }
}