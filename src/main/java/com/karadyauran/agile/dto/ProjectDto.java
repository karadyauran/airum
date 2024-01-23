package com.karadyauran.agile.dto;

import com.karadyauran.agile.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
@Tag(name = "Project", description = "Dto for project")
public class ProjectDto
{
    User owner;
    String projectName;
    String description;
    List<User> users;
}
