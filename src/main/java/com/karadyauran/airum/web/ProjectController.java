package com.karadyauran.airum.web;

import com.karadyauran.airum.api.ProjectApi;
import com.karadyauran.airum.dto.ProjectDto;
import com.karadyauran.airum.entity.Project;
import com.karadyauran.airum.service.interf.ProjectService;
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

import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectController implements ProjectApi
{
    ProjectService service;

    @Operation(summary = "Get Project by ID",
            description = "Fetches a project by its unique identifier.",
            tags = { "PROJECTS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Project found",
                            content = @Content(schema = @Schema(implementation = ProjectDto.class))),
                    @ApiResponse(responseCode = "404", description = "Project not found")
            })

    @Override
    public ResponseEntity<ProjectDto> getProject(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getProject(id));
    }

    @Operation(summary = "Get Project by Name",
            description = "Fetches projects matching the specified name.",
            tags = { "PROJECTS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Projects found",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProjectDto.class)))),
                    @ApiResponse(responseCode = "404", description = "No projects found with the specified name")
            })
    @Override
    public ResponseEntity<List<ProjectDto>> getProjectByName(String name)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getProjectByName(name));
    }

    @Operation(summary = "Get User Projects",
            description = "Fetches projects owned by the specified user.",
            tags = { "PROJECTS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "User's projects found",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = ProjectDto.class)))),
                    @ApiResponse(responseCode = "404", description = "No projects found for the user")
            })
    @Override
    public ResponseEntity<List<ProjectDto>> getUserProjects(UUID userId)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getUserProjects(userId));
    }

    @Operation(summary = "Change Project Name",
            description = "Updates the name of the specified project.",
            tags = { "PROJECTS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Project name updated",
                            content = @Content(schema = @Schema(implementation = ProjectDto.class))),
                    @ApiResponse(responseCode = "404", description = "Project not found")
            })
    @Override
    public ResponseEntity<ProjectDto> changeName(UUID id, String newName)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeName(id, newName));
    }

    @Operation(summary = "Change Project Description",
            description = "Updates the description of the specified project.",
            tags = { "PROJECTS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Project description updated",
                            content = @Content(schema = @Schema(implementation = ProjectDto.class))),
                    @ApiResponse(responseCode = "404", description = "Project not found")
            })
    @Override
    public ResponseEntity<ProjectDto> changeDescription(UUID id, String newDescription)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeDescription(id, newDescription));
    }

    @Operation(summary = "Handle Project Ownership",
            description = "Transfers the ownership of the specified project to a new owner.",
            tags = { "PROJECTS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Project ownership transferred",
                            content = @Content(schema = @Schema(implementation = ProjectDto.class))),
                    @ApiResponse(responseCode = "404", description = "Project or new owner not found")
            })
    @Override
    public ResponseEntity<ProjectDto> handleProject(UUID id, UUID newOwner)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.handleProject(id, newOwner));
    }

    @Operation(summary = "Create Project",
            description = "Creates a new project with the given details.",
            tags = { "PROJECTS" },
            requestBody = @RequestBody(description = "Project details", required = true,
                    content = @Content(schema = @Schema(implementation = Project.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Project created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid project details provided")
            })
    @Override
    public ResponseEntity<ProjectDto> create(Project project)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.create(project));
    }

    @Operation(summary = "Delete Project",
            description = "Deletes the specified project.",
            tags = { "PROJECTS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Project deleted successfully"),
                    @ApiResponse(responseCode = "404", description = "Project not found")
            })
    @Override
    public ResponseEntity<Void> delete(UUID id)
    {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
