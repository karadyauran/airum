package com.karadyauran.agile.web;

import com.karadyauran.agile.api.ProjectApi;
import com.karadyauran.agile.dto.ProjectDto;
import com.karadyauran.agile.entity.Project;
import com.karadyauran.agile.service.interf.ProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectController implements ProjectApi
{
    ProjectService service;

    @Override
    public ResponseEntity<ProjectDto> getProject(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getProject(id));
    }

    @Override
    public ResponseEntity<List<ProjectDto>> getProjectByName(String name)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getProjectByName(name));
    }

    @Override
    public ResponseEntity<List<ProjectDto>> getUserProjects(UUID userId)
    {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(service.getUserProjects(userId));
    }

    @Override
    public ResponseEntity<ProjectDto> changeName(UUID id, String newName)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeName(id, newName));
    }

    @Override
    public ResponseEntity<ProjectDto> changeDescription(UUID id, String newDescription)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeDescription(id, newDescription));
    }

    @Override
    public ResponseEntity<ProjectDto> handleProject(UUID id, UUID newOwner)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.handleProject(id, newOwner));
    }

    @Override
    public ResponseEntity<ProjectDto> create(Project project)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.create(project));
    }

    @Override
    public ResponseEntity<Void> delete(UUID id)
    {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
