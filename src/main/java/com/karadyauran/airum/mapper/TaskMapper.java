package com.karadyauran.airum.mapper;

import com.karadyauran.airum.dto.TaskDto;
import com.karadyauran.airum.dto.shortDto.TaskShortDto;
import com.karadyauran.airum.dto.shortDto.UserShortDto;
import com.karadyauran.airum.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface TaskMapper
{
    // TASK DTO
    TaskDto toDto(Task task);

    List<TaskDto> toDtoList(List<Task> tasks);

    // TASK SHORT DTO
    @Mapping(target = "assignedTo", source = "assignedToUser")
    @Mapping(target = "createdBy", source = "createdByUser")
    TaskShortDto toShortDto(Task task);

    // USER SHORT DTO
    UserShortDto map(UUID value);
}
