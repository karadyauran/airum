package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.ProjectDto;
import com.karadyauran.agile.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        UserMapper.class,
        TaskMapper.class
})
public interface ProjectMapper
{
    ProjectDto toDto(Project project);

    List<ProjectDto> toDtoList(List<Project> projects);
}

