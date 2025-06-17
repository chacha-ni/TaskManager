package com.example.demo.Repositories;
import org.springframework.stereotype.Repository;
import com.example.demo.Models.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {
  private  List<Task> taskList = new ArrayList<>();


//   getAllTasks ▪
// findTaskById ▪
// markTaskAsCompleted ▪
// deleteTask ▪
    public Task addTask(Task task) {
        taskList.add(task);
        return task;
    }
    public List<Task> getAllTasks() {
        return taskList;
    }
    public Optional<Task> findTaskById(Long id) {
        return taskList.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }

public boolean deleteTask(Long id) {
    Optional<Task> taskOpt = findTaskById(id);
    if (taskOpt.isPresent()) {
        taskList.remove(taskOpt.get());
        return true;
    }
    return false;
}
public void markTaskAsCompleted(Long id) {
    Optional<Task> taskOpt = findTaskById(id);
    if (taskOpt.isPresent()) {
        Task task = taskOpt.get();
        task.setCompleted(true);
    } else {
        throw new IllegalArgumentException("Task not found with ID: " + id);
    }
}
}
