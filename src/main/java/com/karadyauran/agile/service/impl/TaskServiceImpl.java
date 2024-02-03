package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.dto.TaskDto;
import com.karadyauran.agile.entity.Task;
import com.karadyauran.agile.entity.enums.TaskStatus;
import com.karadyauran.agile.error.ProjectWasNotFoundException;
import com.karadyauran.agile.error.TaskWasNotFoundException;
import com.karadyauran.agile.error.UserWasNotFoundException;
import com.karadyauran.agile.error.message.ErrorMessage;
import com.karadyauran.agile.mapper.TaskMapper;
import com.karadyauran.agile.repository.ProjectRepository;
import com.karadyauran.agile.repository.TaskRepository;
import com.karadyauran.agile.repository.UserRepository;
import com.karadyauran.agile.service.interf.TaskService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TaskServiceImpl implements TaskService
{
    TaskRepository taskRepository;
    TaskMapper taskMapper;

    ProjectRepository projectRepository;
    UserRepository userRepository;

    @Override
    public TaskDto getTaskById(UUID id)
    {
        if (checkTaskById(id))
        {
            throw new TaskWasNotFoundException(ErrorMessage.TASK_WAS_NOT_FOUND);
        }

        return taskMapper.toDto(
                taskRepository.findById(id)
                        .orElseThrow(() -> new TaskWasNotFoundException(ErrorMessage.TASK_WAS_NOT_FOUND))
        );
    }

    @Override
    public List<TaskDto> getTasksByProjectId(UUID id)
    {
        if (checkProjectById(id))
        {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        return taskMapper.toDtoList(
                taskRepository.findTasksByProjectId(id)
                        .orElseThrow(() -> new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND))
        );
    }

    @Override
    public List<TaskDto> getTasksForProjectByStatus(UUID id, String status)
    {
        if (checkProjectById(id))
        {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        return taskMapper.toDtoList(
                taskRepository.findTasksByProjectIdAndStatus(id, TaskStatus.valueOf(status))
                        .orElseThrow(() -> new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND))
        );
    }

    @Override
    @Transactional
    public TaskDto changeTaskTitle(UUID id, String newTitle)
    {
        if (checkTaskById(id))
        {
            throw new TaskWasNotFoundException(ErrorMessage.TASK_WAS_NOT_FOUND);
        }

        taskRepository.changeTaskTitle(id, newTitle);
        return taskMapper.toDto(
                taskRepository.findById(id)
                        .orElse(null)
        );
    }

    @Override
    @Transactional
    public TaskDto changeTaskDescription(UUID id, String newDescription)
    {
        if (checkTaskById(id))
        {
            throw new TaskWasNotFoundException(ErrorMessage.TASK_WAS_NOT_FOUND);
        }

        taskRepository.changeTaskDescription(id, newDescription);
        return taskMapper.toDto(
                taskRepository.findById(id)
                        .orElse(null)
        );
    }

    @Override
    @Transactional
    public TaskDto assignToUser(UUID id, UUID userId)
    {
        if (checkTaskById(id))
        {
            throw new TaskWasNotFoundException(ErrorMessage.TASK_WAS_NOT_FOUND);
        }

        if (checkUserById(id))
        {
            throw new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND);
        }

        taskRepository.changeAssignToUser(id, userId);
        return taskMapper.toDto(
                taskRepository.findById(id)
                        .orElse(null)
        );
    }

    @Override
    @Transactional
    public TaskDto changeDate(UUID id, Date date)
    {
        if (checkTaskById(id))
        {
            throw new TaskWasNotFoundException(ErrorMessage.TASK_WAS_NOT_FOUND);
        }

        taskRepository.changeDueToDate(id, date);
        return taskMapper.toDto(
                taskRepository.findById(id)
                        .orElse(null)
        );
    }

    @Override
    @Transactional
    public void delete(UUID id)
    {
        if (checkTaskById(id))
        {
            throw new TaskWasNotFoundException(ErrorMessage.TASK_WAS_NOT_FOUND);
        }

        taskRepository.deleteById(id);
    }

    @Override
    public TaskDto create(Task task)
    {
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    private boolean checkUserById(UUID id)
    {
        return userRepository.findById(id).orElse(null) == null;
    }

    private boolean checkProjectById(UUID id)
    {
        return projectRepository.findById(id).orElse(null) == null;
    }

    private boolean checkTaskById(UUID id)
    {
        return taskRepository.findById(id).orElse(null) == null;
    }
}
