package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.ProjectDto;
import com.karadyauran.agile.entity.Project;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper
{
    ProjectDto toDto(Project project);
}
