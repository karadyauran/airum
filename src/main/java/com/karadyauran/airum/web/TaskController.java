package com.karadyauran.airum.web;

import com.karadyauran.airum.api.TaskApi;
import com.karadyauran.airum.dto.TaskDto;
import com.karadyauran.airum.entity.Task;
import com.karadyauran.airum.service.interf.TaskService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Gets task by it's id",
            description = "Returns TaskDto entity",
            tags = "TASKS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<TaskDto> getTaskById(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getTaskById(id));
    }

    @Operation(summary = "Gets tasks by project id",
            description = "Returns List of TaskDto entities",
            tags = "TASKS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<List<TaskDto>> getTasksByProjectId(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getTasksByProjectId(id));
    }

    @Operation(summary = "Gets tasks by project id and status",
            description = "Returns List of TaskDto entities",
            tags = "TASKS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<List<TaskDto>> getTasksForProjectByStatus(UUID id, String status)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getTasksForProjectByStatus(id, status));
    }

    @Operation(summary = "Changes title for Task",
            description = "Returns TaskDto entity",
            tags = "TASKS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<TaskDto> changeTaskTitle(UUID id, String newTitle)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeTaskTitle(id, newTitle));
    }

    @Operation(summary = "Changes description for Task",
            description = "Returns TaskDto entity",
            tags = "TASKS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<TaskDto> changeTaskDescription(UUID id, String newDescription)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeTaskDescription(id, newDescription));
    }

    @Operation(summary = "Assigns task to user",
            description = "Returns TaskDto entity",
            tags = "TASKS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<TaskDto> assignToUser(UUID id, UUID user)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.assignToUser(id, user));
    }

    @Operation(summary = "Changes date for Task",
            description = "Returns TaskDto entity",
            tags = "TASKS",
            // TODO make documentation on github
            /*externalDocs = @ExternalDocumentation(
                    description = "Вот тут вся документация",
                    url = "https://google.com/"
            ),*/
            responses = {
                    @ApiResponse(responseCode = "200", description = "found"),
                    @ApiResponse(responseCode = "500", description = "have not been fount")
            }
            // TODO fill this field for security requirements
            /*security = {
                    @SecurityRequirement(name = "требования к безопасности")
            },*/
    )
    @Override
    public ResponseEntity<TaskDto> changeDate(UUID id, Date newDate)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeDate(id, newDate));
    }

    /**
     * Deletes task
     *
     * @param id
     * @return ResponseEntity
     */
    @Override
    public ResponseEntity<Void> delete(UUID id)
    {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    // TODO translate on english
    @Operation(summary = "Creates new task",
            description = "TaskDto would be the answer",
            tags = "TASKS",
            requestBody = @RequestBody(
                    description = "TASK'S DATA",
                    required = true, //обязательно ли тело запроса для сохранения
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = TaskDto.class) // points on class,
                            // который служит примером реализации схемы для объекта API
                    )
            )
    )
    @Override
    public ResponseEntity<TaskDto> create(Task task)
    {
        service.create(task);
        return ResponseEntity.ok().build();
    }
}
