package com.karadyauran.airum.service.interf;

import com.karadyauran.airum.dto.TaskDto;
import com.karadyauran.airum.entity.Task;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TaskService
{
    TaskDto getTaskById(UUID id);

    List<TaskDto> getTasksByProjectId(UUID id);

    List<TaskDto> getTasksForProjectByStatus(UUID id, String status);

    TaskDto changeTaskTitle(UUID id, String newTitle);

    TaskDto changeTaskDescription(UUID id, String newDescription);

    TaskDto assignToUser(UUID id, UUID userId);

    TaskDto changeDate(UUID id, Date date);

    void delete(UUID id);

    TaskDto create(Task task);
}
