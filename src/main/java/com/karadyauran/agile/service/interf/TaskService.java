package com.karadyauran.agile.service.interf;

import com.karadyauran.agile.entity.Task;

import java.util.UUID;

public interface TaskService
{
    Task getTaskById(UUID id);
}
