package com.karadyauran.airum.api;

import com.karadyauran.airum.dto.ProjectDto;
import com.karadyauran.airum.entity.Project;
import com.karadyauran.airum.validation.interf.Uuid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

public interface ProjectApi
{
    @GetMapping("project")
    ResponseEntity<ProjectDto> getProject(@Uuid @RequestParam UUID id);

    @GetMapping("project/{name}")
    ResponseEntity<List<ProjectDto>> getProjectByName(@Size(min = 5, max = 60) @PathVariable String name);

    @GetMapping("projects")
    ResponseEntity<List<ProjectDto>> getUserProjects(@Uuid @RequestParam UUID userId);

    @PutMapping("project/change-name")
    ResponseEntity<ProjectDto> changeName(@Uuid @RequestParam UUID id, @Size(min = 5, max = 60) @RequestParam String newName);

    @PutMapping("project/change-description")
    ResponseEntity<ProjectDto> changeDescription(@Uuid @RequestParam UUID id, @NotNull @RequestParam String newDescription);

    @PutMapping("project/handle-project")
    ResponseEntity<ProjectDto> handleProject(@Uuid @RequestParam UUID id, @Uuid @RequestParam UUID newOwner);

    @PostMapping("project/create")
    ResponseEntity<ProjectDto> create(@RequestBody Project project);

    @DeleteMapping("project/delete/{id}")
    ResponseEntity<Void> delete(@Uuid @PathVariable UUID id);
}
