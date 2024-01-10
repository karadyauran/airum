package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.entity.Task;
import com.karadyauran.agile.repository.TaskRepository;
import com.karadyauran.agile.service.interf.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService
{
    private final TaskRepository taskRepository;

    @Override
    public Task getTaskById(String taskId)
    {
        return taskRepository.getTaskByTaskId(UUID.fromString(taskId));
    }
}
