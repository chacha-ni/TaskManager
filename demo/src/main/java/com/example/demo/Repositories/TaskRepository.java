package com.example.demo.Repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Models.Task;

@Repository

  public interface TaskRepository extends MongoRepository<Task, String>
   {

  
  } 
 
//    List<Task> taskList = new ArrayList<>();


// //   getAllTasks ▪
// // findTaskById ▪
// // markTaskAsCompleted ▪
// // deleteTask ▪
//     public Task addTask(Task task) {
//         taskList.add(task);
//         return task;
//     }
//     public List<Task> getAllTasks() {
//         return taskList;
//     }
//     public Optional<Task> findTaskById(String id) {
//         return taskList.stream()
//                 .filter(task -> task.getId().equals(id))
//                 .findFirst();
//     }

// public boolean deleteTask(String id) {
//     Optional<Task> taskOpt = findTaskById(id);
//     if (taskOpt.isPresent()) {
//         taskList.remove(taskOpt.get());
//         return true;
//     }
//     return false;
// }


