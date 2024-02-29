package com.karadyauran.airum.api;

import com.karadyauran.airum.dto.TaskDto;
import com.karadyauran.airum.entity.Task;
import com.karadyauran.airum.validation.interf.StatusValidator;
import com.karadyauran.airum.validation.interf.Uuid;
import jakarta.validation.constraints.Size;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TaskApi
{
    @GetMapping("task/{id}")
    ResponseEntity<TaskDto> getTaskById(@Uuid @PathVariable UUID id);

    @GetMapping("task/project")
    ResponseEntity<List<TaskDto>> getTasksByProjectId(@Uuid @RequestParam UUID id);

    @GetMapping("task/status")
    ResponseEntity<List<TaskDto>> getTasksForProjectByStatus(@Uuid @RequestParam UUID id, @StatusValidator @RequestParam String status);

    @PutMapping("task/change-title")
    ResponseEntity<TaskDto> changeTaskTitle(@Uuid @RequestParam UUID id, @Size(min = 5, max = 60) @RequestParam String newTitle);

    @PutMapping("task/change-description")
    ResponseEntity<TaskDto> changeTaskDescription(@Uuid @RequestParam UUID id, @RequestParam String newDescription);

    @PutMapping("task/assign-to-user")
    ResponseEntity<TaskDto> assignToUser(@Uuid @RequestParam UUID id, @Uuid @RequestParam UUID user);

    @PutMapping("task/change-date")
    ResponseEntity<TaskDto> changeDate(@Uuid @RequestParam UUID id,
                                       @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                       @RequestParam Date newDate
    );

    @DeleteMapping("task/delete")
    ResponseEntity<Void> delete(@Uuid @RequestParam UUID id);

    @PostMapping("task/create")
    ResponseEntity<TaskDto> create(@RequestBody Task task);
}
