package com.karadyauran.airum.service.impl;


import com.karadyauran.airum.dto.ProjectDto;
import com.karadyauran.airum.entity.Project;
import com.karadyauran.airum.error.ProjectWasNotFoundException;
import com.karadyauran.airum.error.message.ErrorMessage;
import com.karadyauran.airum.mapper.ProjectMapper;
import com.karadyauran.airum.repository.ProjectRepository;
import com.karadyauran.airum.service.interf.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectServiceImpl implements ProjectService
{
    ProjectRepository repository;
    ProjectMapper mapper;

    @Override
    @Transactional
    public ProjectDto getProject(UUID id)
    {
        return mapper.toDto(
                repository.findById(id)
                        .orElseThrow(() -> new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND))
        );
    }

    @Override
    @Transactional
    public List<ProjectDto> getProjectByName(String name)
    {
        return mapper.toDtoList(
                repository.findAllByName(name)
        );
    }

    @Override
    @Transactional
    public List<ProjectDto> getUserProjects(UUID creatorId)
    {
        return mapper.toDtoList(
                repository.findAllByCreatorId(creatorId)
        );
    }

    @Override
    @Transactional
    public ProjectDto changeName(UUID id, String newName)
    {
        if (projectIsNotExists(id))
        {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        repository.changeName(id, newName);
        return mapper.toDto(
                repository.findById(id).orElse(null)
        );
    }

    @Override
    @Transactional
    public ProjectDto changeDescription(UUID id, String newDescription)
    {
        if (projectIsNotExists(id))
        {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        repository.changeDescription(id, newDescription);
        return mapper.toDto(
                repository.findById(id).orElse(null)
        );
    }

    @Override
    @Transactional
    public ProjectDto handleProject(UUID id, UUID newOwner)
    {
        if (projectIsNotExists(id))
        {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        repository.changeOwner(id, newOwner);
        return mapper.toDto(
                repository.findById(id).orElse(null)
        );
    }

    @Override
    @Transactional
    public ProjectDto create(Project project)
    {
        repository.save(project);
        return mapper.toDto(project);
    }

    @Override
    @Transactional
    public void delete(UUID id)
    {
        if (projectIsNotExists(id))
        {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        repository.deleteById(id);
    }

    private boolean projectIsNotExists(UUID id)
    {
        return !repository.existsById(id);
    }
}
