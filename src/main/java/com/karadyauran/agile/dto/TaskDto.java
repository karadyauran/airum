package com.karadyauran.agile.dto;

import com.karadyauran.agile.entity.Project;
import com.karadyauran.agile.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Tag(name = "Task", description = "Dto for task")
public class TaskDto
{
    String title;
    String description;
    String status;
    Project project;
    User assignedTo;
    User createdBy;
}