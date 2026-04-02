package com.example.demo.Models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection = "tasks")
public class Task {
    @Id
    private String id;
    private String name;
    private String description;
    private boolean completed;
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}
