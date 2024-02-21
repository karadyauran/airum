package com.karadyauran.airum.mapper;

import com.karadyauran.airum.dto.ProjectDto;
import com.karadyauran.airum.entity.Project;
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
}

