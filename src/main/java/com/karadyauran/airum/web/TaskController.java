package com.karadyauran.airum.web;

import com.karadyauran.airum.api.TaskApi;
import com.karadyauran.airum.dto.TaskDto;
import com.karadyauran.airum.entity.Task;
import com.karadyauran.airum.service.interf.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Get Task by ID",
            description = "Fetches a task by its unique identifier.",
            tags = { "TASKS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task found",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
                    @ApiResponse(responseCode = "404", description = "Task not found")
            })
    @Override
    public ResponseEntity<TaskDto> getTaskById(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getTaskById(id));
    }

    @Operation(summary = "Get Tasks by Project ID",
            description = "Fetches all tasks associated with a given project ID.",
            tags = { "TASKS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Tasks found",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = TaskDto.class)))),
                    @ApiResponse(responseCode = "404", description = "No tasks found for the project")
            })
    @Override
    public ResponseEntity<List<TaskDto>> getTasksByProjectId(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getTasksByProjectId(id));
    }

    @Operation(summary = "Get Tasks for Project by Status",
            description = "Fetches tasks for a project filtered by status.",
            tags = { "TASKS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Tasks found",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = TaskDto.class)))),
                    @ApiResponse(responseCode = "404", description = "No tasks found with the specified status")
            })
    @Override
    public ResponseEntity<List<TaskDto>> getTasksForProjectByStatus(UUID id, String status)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getTasksForProjectByStatus(id, status));
    }

    @Operation(summary = "Change Task Title",
            description = "Updates the title of the specified task.",
            tags = { "TASKS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task title updated",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
                    @ApiResponse(responseCode = "404", description = "Task not found")
            })
    @Override
    public ResponseEntity<TaskDto> changeTaskTitle(UUID id, String newTitle)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeTaskTitle(id, newTitle));
    }

    @Operation(summary = "Change Task Description",
            description = "Updates the description of the specified task.",
            tags = { "TASKS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task description updated",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
                    @ApiResponse(responseCode = "404", description = "Task not found")
            })
    @Override
    public ResponseEntity<TaskDto> changeTaskDescription(UUID id, String newDescription)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeTaskDescription(id, newDescription));
    }

    @Operation(summary = "Assign Task to User",
            description = "Assigns the specified task to a user.",
            tags = { "TASKS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task assigned to user",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
                    @ApiResponse(responseCode = "404", description = "Task or user not found")
            })
    @Override
    public ResponseEntity<TaskDto> assignToUser(UUID id, UUID user)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.assignToUser(id, user));
    }

    @Operation(summary = "Change Task Date",
            description = "Updates the due date of the specified task.",
            tags = { "TASKS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task date updated",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
                    @ApiResponse(responseCode = "404", description = "Task not found")
            })
    @Override
    public ResponseEntity<TaskDto> changeDate(UUID id, Date newDate)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeDate(id, newDate));
    }

    @Operation(summary = "Delete Task",
            description = "Deletes the specified task.",
            tags = { "TASKS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task deleted successfully"),
                    @ApiResponse(responseCode = "404", description = "Task not found")
            })
    @Override
    public ResponseEntity<Void> delete(UUID id)
    {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Create Task",
            description = "Creates a new task with the given details.",
            tags = { "TASKS" },
            requestBody = @RequestBody(description = "Task to be created", required = true,
                    content = @Content(schema = @Schema(implementation = Task.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Task created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid task details provided")
            })
    @Override
    public ResponseEntity<TaskDto> create(Task task)
    {
        service.create(task);
        return ResponseEntity.ok().build();
    }
}
