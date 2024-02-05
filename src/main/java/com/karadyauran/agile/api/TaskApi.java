package com.karadyauran.agile.api;

import com.karadyauran.agile.dto.TaskDto;
import com.karadyauran.agile.entity.Task;
import com.karadyauran.agile.validation.interf.Uuid;
import com.karadyauran.agile.validation.interf.StatusValidator;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TaskApi
{
    @GetMapping("task")
    ResponseEntity<TaskDto> getTaskById(@Uuid @RequestParam UUID id);

    @GetMapping("task/project")
    ResponseEntity<List<TaskDto>> getTasksByProjectId(@Uuid @RequestParam UUID id);

    @GetMapping("task/")
    ResponseEntity<List<TaskDto>> getTasksForProjectByStatus(@Uuid @RequestParam UUID id, @StatusValidator  @RequestParam String status);

    @PutMapping("task/change-title")
    ResponseEntity<TaskDto> changeTaskTitle(@Uuid @RequestParam UUID id, @Size(min = 5, max = 60) @RequestParam String newTitle);

    @PutMapping("task/change-description")
    ResponseEntity<TaskDto> changeTaskDescription(@Uuid @RequestParam UUID id, @RequestParam String newDescription);

    @PutMapping("task/assign-to-user")
    ResponseEntity<TaskDto> assignToUser(@Uuid @RequestParam UUID id, @Uuid @RequestParam UUID user);

    @PutMapping("task/change-date")
    ResponseEntity<TaskDto> changeDate(@Uuid @RequestParam UUID id, @DateTimeFormat @RequestParam Date newDate);

    @DeleteMapping("task/delete")
    ResponseEntity<Void> delete(@Uuid @RequestParam UUID id);

    @PostMapping("task/create")
    ResponseEntity<TaskDto> create(@RequestBody Task task);
}
