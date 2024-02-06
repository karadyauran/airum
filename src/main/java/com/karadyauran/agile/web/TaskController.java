package com.karadyauran.agile.web;

import com.karadyauran.agile.api.TaskApi;
import com.karadyauran.agile.dto.TaskDto;
import com.karadyauran.agile.entity.Task;
import com.karadyauran.agile.service.interf.TaskService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TaskController implements TaskApi
{
    TaskService service;

    @Override
    public ResponseEntity<TaskDto> getTaskById(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getTaskById(id));
    }

    @Override
    public ResponseEntity<List<TaskDto>> getTasksByProjectId(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getTasksByProjectId(id));
    }

    @Override
    public ResponseEntity<List<TaskDto>> getTasksForProjectByStatus(UUID id, String status)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getTasksForProjectByStatus(id, status));
    }

    @Override
    public ResponseEntity<TaskDto> changeTaskTitle(UUID id, String newTitle)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeTaskTitle(id, newTitle));
    }

    @Override
    public ResponseEntity<TaskDto> changeTaskDescription(UUID id, String newDescription)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeTaskDescription(id, newDescription));
    }

    @Override
    public ResponseEntity<TaskDto> assignToUser(UUID id, UUID user)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.assignToUser(id, user));
    }

    @Override
    public ResponseEntity<TaskDto> changeDate(UUID id, Date newDate)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeDate(id, newDate));
    }

    @Override
    public ResponseEntity<Void> delete(UUID id)
    {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<TaskDto> create(Task task)
    {
        service.create(task);
        return ResponseEntity.ok().build();
    }
}
