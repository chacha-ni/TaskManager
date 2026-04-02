package com.example.demo.Services;
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
    // private final IdGenerator idGenerator;
// public TaskService(@Autowired TaskRepository taskRepository,@Autowired IdGenerator idGenerator) {
//     this.taskRepository = taskRepository;
//     this.idGenerator = idGenerator;
// }
    // public Task addTask(Task task) {
    //     if (task == null) 
    //      throw new IllegalArgumentException("Task cannot be null");
    //     // task.setId(idGenerator.getNextId());
    //       task.setCompleted(false);
    //     if (task.getName() == null || task.getName().isEmpty()) 
    //      throw new IllegalArgumentException("Task name cannot be null or empty");
    //     return taskRepository.addTask(task);
    // }
    // הוספת משימה חדשה
    public Task addTask(Task task) {
        if (task == null) 
            throw new IllegalArgumentException("Task cannot be null");
        
        task.setCompleted(false);
        
        if (task.getName() == null || task.getName().isEmpty()) 
            throw new IllegalArgumentException("Task name cannot be null or empty");
        
        // השמירה ב-MongoDB - ה-ID ייווצר אוטומטית
        return taskRepository.save(task);
    }
    // public List<Task> getAllTasks() {
    //     List<Task> tasks = taskRepository.getAllTasks();
    //     if (tasks == null || tasks.isEmpty()) {
    //         return new ArrayList<>(); 
    //     }
    //     return tasks;
    // }
    // שליפת כל המשימות
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    // public Optional<Task> findTaskById(String id) {
    //     if (id == null
    //     //  || id <= 0
    //     ) 
    //      throw new IllegalArgumentException("Invalid task ID");
    //    Optional<Task> taskOpt = taskRepository.findTaskById(id);
    //    if (taskOpt.isPresent()) {
    //     return taskOpt;
    // }
    //  throw new IllegalArgumentException("Task not found with ID: " + id);
    // }

public Optional<Task> findTaskById(String id) {
        if (id == null) 
            throw new IllegalArgumentException("Invalid task ID");
            
        return taskRepository.findById(id);
    }
    
  
    public void deleteTask(String id) {
        if (id == null) 
            throw new IllegalArgumentException("Invalid task ID");
            
        taskRepository.deleteById(id);
    }
     public void markTaskAsCompleted(String id) {
    Optional<Task> taskOpt = taskRepository.findById(id);
    if (taskOpt.isPresent()) {
        Task task = taskOpt.get();
        task.setCompleted(true);
    } else {
        throw new IllegalArgumentException("Task not found with ID: " + id);
    }
}
//    public void markTaskAsCompleted(String id) {
//         if (id == null 
//         // || id <= 
//         ) 
//          throw new IllegalArgumentException("Invalid task ID");
//         taskRepository.markTaskAsCompleted(id);
//     }

    
}