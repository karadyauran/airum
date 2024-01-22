package com.karadyauran.agile.dto;

import com.karadyauran.agile.entity.Project;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public record UserDto(String userId, String username, String name, String surname, List<Project> projects)
{
}
