package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.entity.Task;
import com.karadyauran.agile.entity.enums.TaskStatus;
import com.karadyauran.agile.repository.TaskRepository;
import com.karadyauran.agile.service.interf.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService
{
    private final TaskRepository taskRepository;

    @Override
    public Task getTaskById(String taskId)
    {
        return taskRepository.findByTaskId(UUID.fromString(taskId));
    }

    @Override
    public List<Task> getTasksByStatus(String status)
    {
        return taskRepository.findTaskByStatus(TaskStatus.valueOf(status));
    }

    @Override
    public List<Task> getAllTasks()
    {
        return taskRepository.getAllTasks();
    }
}
