package com.karadyauran.airum.service.interf;

import com.karadyauran.airum.dto.ProjectDto;
import com.karadyauran.airum.entity.Project;

import java.util.List;
import java.util.UUID;

public interface ProjectService
{
    ProjectDto getProject(UUID id);

    List<ProjectDto> getProjectByName(String name);

    List<ProjectDto> getUserProjects(UUID userId);

    ProjectDto changeName(UUID id, String newName);

    ProjectDto changeDescription(UUID id, String newDescription);

    ProjectDto handleProject(UUID id, UUID newOwner);

    ProjectDto create(Project project);

    void delete(UUID id);
}
