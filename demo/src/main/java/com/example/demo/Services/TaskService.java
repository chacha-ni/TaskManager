package com.example.demo.Services;
import java.util.List;
import java.util.Optional;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Models.Task;
import com.example.demo.Models.enums.TaskPriority;
import com.example.demo.Models.enums.TaskStatus;
import com.example.demo.Repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
// import org.bson.types.ObjectId;
@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
     public Task addTask(Task task) {
        if (task == null) 
            throw new IllegalArgumentException("Task cannot be null");

        if (task.getName() == null || task.getName().isEmpty()) 
            throw new IllegalArgumentException("Task name cannot be null or empty");

        if(task.getDescription() == null || task.getDescription().isEmpty()) 
           task.setDescription(task.getName()+" description");

        if(task.getTaskPriority() == null || task.getTaskPriority().toString().isEmpty())
          task.setTaskPriority(TaskPriority.LOW);

          task.setStatus(TaskStatus.TODO); 

        if(task.getDeadline() == null) 
          task.setDeadline(LocalDateTime.now().plusDays(1)); 

          task.setCreatedAt(LocalDateTime.now());

          Task savedTask = taskRepository.save(task);

        if (savedTask.getParentTaskId() != null && !savedTask.getParentTaskId().isEmpty()) {
        updateParentTask(savedTask); 
    }
        return savedTask;
    }
     private void updateParentTask(Task childTask) {
    Optional<Task> parentTaskOpt = taskRepository.findById(childTask.getParentTaskId());
    if (parentTaskOpt.isPresent()) {
        Task parentTask = parentTaskOpt.get();
        parentTask.getSubTaskIds().add(childTask.getId()); // כאן ה-ID כבר לא null!
        taskRepository.save(parentTask);
    } else {
        throw new IllegalArgumentException("Parent task not found");
    }
}
     public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

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

    //      public void taskStatus(String id) {
//     Optional<Task> taskOpt = taskRepository.findById(id);
//     if (taskOpt.isPresent()) {
//         Task task = taskOpt.get();
//         task.setCompleted(true);
//     } else {
//         throw new IllegalArgumentException("Task not found with ID: " + id);
//     }
// }


}