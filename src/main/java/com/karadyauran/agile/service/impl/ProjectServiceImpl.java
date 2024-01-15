package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.entity.Project;
import com.karadyauran.agile.repository.ProjectRepository;
import com.karadyauran.agile.service.interf.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService
{
    private final ProjectRepository projectRepository;

    @Override
    public Project getProjectById(String id)
    {
        return projectRepository.findProjectByProjectId(UUID.fromString(id));
    }
}
