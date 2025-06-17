package com.example.demo.Models;
import lombok.Data;


@Data
public class Task {
    private Long id;
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
