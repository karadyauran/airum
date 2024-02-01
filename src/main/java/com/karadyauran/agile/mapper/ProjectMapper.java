package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.ProjectDto;
import com.karadyauran.agile.dto.shortDto.ProjectShortDto;
import com.karadyauran.agile.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {
        UserMapper.class,
        TaskMapper.class
})
public interface ProjectMapper
{
    // PROJECT DTO
    @Mappings({
            @Mapping(target = "members", source = "users"),
            @Mapping(target = "tasks", source = "tasks")
    })
    ProjectDto toDto(Project project);

    List<ProjectDto> toDtoList(List<Project> projects);

    // PROJECT SHORT DTO
    ProjectShortDto toShortDto(Project project);
}

