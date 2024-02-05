package com.karadyauran.agile.api;

import com.karadyauran.agile.dto.ProjectDto;
import com.karadyauran.agile.entity.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface ProjectApi
{
    @GetMapping("project")
    ResponseEntity<ProjectDto> getProject(@RequestParam UUID id);

    @GetMapping("project/{name}")
    ResponseEntity<List<ProjectDto>> getProjectByName(@PathVariable String name);

    @GetMapping("projects")
    ResponseEntity<List<ProjectDto>> getUserProjects(@RequestParam UUID userId);

    @PutMapping("project/change-name")
    ResponseEntity<ProjectDto> changeName(@RequestParam UUID id, @RequestParam String newName);

    @PutMapping("project/change-description")
    ResponseEntity<ProjectDto> changeDescription(@RequestParam UUID id, @RequestParam String newDescription);

    @PutMapping("project/handle-project")
    ResponseEntity<ProjectDto> handleProject(@RequestParam UUID id, @RequestParam UUID newOwner);

    @PostMapping("project/create")
    ResponseEntity<ProjectDto> create(@RequestBody Project project);

    @DeleteMapping("project/delete/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);
}
