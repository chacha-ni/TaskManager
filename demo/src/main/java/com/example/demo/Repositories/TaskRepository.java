package com.example.demo.Repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Models.Task;

@Repository

  public interface TaskRepository extends MongoRepository<Task, String>
   {

  
  } 
 
