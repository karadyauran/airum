package com.karadyauran.agile.service.impl;


import com.karadyauran.agile.dto.ProjectDto;
import com.karadyauran.agile.entity.Project;
import com.karadyauran.agile.error.ProjectWasNotFoundException;
import com.karadyauran.agile.error.message.ErrorMessage;
import com.karadyauran.agile.mapper.ProjectMapper;
import com.karadyauran.agile.mapper.UserMapper;
import com.karadyauran.agile.repository.ProjectRepository;
import com.karadyauran.agile.repository.UserRepository;
import com.karadyauran.agile.service.interf.ProjectService;
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
    ProjectRepository projectRepository;
    UserRepository userRepository;

    ProjectMapper projectMapper;
    UserMapper userMapper;

    @Override
    public ProjectDto getProject(UUID id)
    {
        return projectMapper.toDto(
                projectRepository.findById(id)
                        .orElseThrow(() -> new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND)),
                userRepository,
                userMapper
        );
    }

    @Override
    public List<ProjectDto> getProjectByName(String name)
    {
        return projectMapper.toDtoList(
                projectRepository.findAllByName(name),
                userRepository,
                userMapper
        );
    }

    @Override
    public List<ProjectDto> getUserProjects(UUID creatorId)
    {
        return projectMapper.toDtoList(
                projectRepository.findAllByCreatorId(creatorId),
                userRepository,
                userMapper
        );
    }

    @Override
    @Transactional
    public ProjectDto changeName(UUID id, String newName)
    {
        if (checkProject(id)) {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        projectRepository.changeName(id, newName);
        return projectMapper.toDto(
                projectRepository.findById(id).orElse(null),
                userRepository,
                userMapper
        );
    }

    @Override
    @Transactional
    public ProjectDto changeDescription(UUID id, String newDescription)
    {
        if (checkProject(id)) {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        projectRepository.changeDescription(id, newDescription);
        return projectMapper.toDto(
                projectRepository.findById(id).orElse(null),
                userRepository,
                userMapper
        );
    }

    @Override
    @Transactional
    public ProjectDto handleProject(UUID id, UUID newOwner)
    {
        if (checkProject(id)) {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        projectRepository.changeOwner(id, newOwner);
        return projectMapper.toDto(
                projectRepository.findById(id).orElse(null),
                userRepository,
                userMapper
        );
    }

    @Override
    public ProjectDto create(Project project)
    {
        projectRepository.save(project);
        return projectMapper.toDto(
                project,
                userRepository,
                userMapper
        );
    }

    @Override
    public void delete(UUID id)
    {
        if (checkProject(id)) {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        projectRepository.deleteById(id);
    }

    private boolean checkProject(UUID id)
    {
        return projectRepository.findById(id).orElse(null) == null;
    }
}
