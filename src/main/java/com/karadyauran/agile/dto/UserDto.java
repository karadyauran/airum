package com.karadyauran.agile.dto;

import com.karadyauran.agile.entity.Project;
import lombok.Builder;

import java.util.List;

@Builder
public record UserDto(
        String username,
        String name,
        String surname,
        List<Project> ownedProjects
)
{
}
