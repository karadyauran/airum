package com.karadyauran.agile.service.interf;

import com.karadyauran.agile.entity.Task;

import java.util.List;

public interface TaskService
{
    Task getTaskById(String id);
    List<Task> getTasksByStatus(String status);
    List<Task> getAllTasks();
    Task createTask(Task task);
}
