package com.example.demo.Models;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.example.demo.Models.enums.TaskPriority;
import com.example.demo.Models.enums.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Document(collection = "tasks")
public class Task {
    @Id
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private String id;
    // @Schema(example = "")
    private String name;
    // @Schema(example = "")
    private String description;
    // private boolean completed;
    private TaskPriority taskPriority;  
    private TaskStatus status;
    // @Schema(example = "null")
    private LocalDateTime deadline;
    @CreatedDate
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private LocalDateTime createdAt;
    // @Schema(example = "null")
    private String parentTaskId;
    // @Schema(example = "null")
    private List<String> subTaskIds = new ArrayList<>();
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + taskPriority +
                ", status=" + status +
                ", deadline=" + (deadline != null ? deadline : "None") +
                ", createdAt=" + (createdAt != null ? createdAt : "None") +
                '}';
    }
}
