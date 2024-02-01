package com.karadyauran.agile.service.impl;


import com.karadyauran.agile.dto.ProjectDto;
import com.karadyauran.agile.entity.Project;
import com.karadyauran.agile.error.ProjectWasNotFoundException;
import com.karadyauran.agile.error.message.ErrorMessage;
import com.karadyauran.agile.mapper.ProjectMapper;
import com.karadyauran.agile.repository.ProjectRepository;
import com.karadyauran.agile.service.interf.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Qualifier("projectMapper")
    ProjectMapper mapper;

    @Override
    public ProjectDto getProject(UUID id)
    {
        return mapper.toDto(
                repository.findById(id)
                        .orElseThrow(() -> new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND))
        );
    }

    @Override
    public List<ProjectDto> getProjectByName(String name)
    {
        return mapper.toDtoList(
                repository.findAllByName(name)
        );
    }

    @Override
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
        if (checkProject(id)) {
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
        if (checkProject(id)) {
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
        if (checkProject(id)) {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        repository.changeOwner(id, newOwner);
        return mapper.toDto(
                repository.findById(id).orElse(null)
        );
    }

    @Override
    public ProjectDto create(Project project)
    {
        repository.save(project);
        return mapper.toDto(project);
    }

    @Override
    public void delete(UUID id)
    {
        if (checkProject(id)) {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        repository.deleteById(id);
    }

    private boolean checkProject(UUID id)
    {
        return repository.findById(id).orElse(null) == null;
    }
}
