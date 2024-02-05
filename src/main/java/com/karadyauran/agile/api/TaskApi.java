package com.karadyauran.agile.api;

import com.karadyauran.agile.dto.TaskDto;
import com.karadyauran.agile.entity.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TaskApi
{
    @GetMapping("task")
    ResponseEntity<TaskDto> getTaskById(@RequestParam UUID id);

    @GetMapping("task/project")
    ResponseEntity<List<TaskDto>> getTasksByProjectId(@RequestParam UUID id);

    @GetMapping("task/")
    ResponseEntity<List<TaskDto>> getTasksForProjectByStatus(@RequestParam UUID id, @RequestParam String status);

    @PutMapping("task/change-title")
    ResponseEntity<TaskDto> changeTaskTitle(@RequestParam UUID id, @RequestParam String newTitle);

    @PutMapping("task/change-description")
    ResponseEntity<TaskDto> changeTaskDescription(@RequestParam UUID id, @RequestParam String newDescription);

    @PutMapping("task/assign-to-user")
    ResponseEntity<TaskDto> assignToUser(@RequestParam UUID id, @RequestParam UUID user);

    @PutMapping("task/change-date")
    ResponseEntity<TaskDto> changeDate(@RequestParam UUID id, @RequestParam Date newDate);

    @DeleteMapping("task/delete")
    ResponseEntity<Void> delete(@RequestParam UUID id);

    @PostMapping("task/create")
    ResponseEntity<TaskDto> create(@RequestBody Task task);
}
