package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.TaskDto;
import com.karadyauran.agile.dto.shortDto.TaskShortDto;
import com.karadyauran.agile.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

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
}
