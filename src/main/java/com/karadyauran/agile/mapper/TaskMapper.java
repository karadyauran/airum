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

    // TASK SHORT DTO
    @Mapping(target = "assignedTo", source = "assignedToUser")
    TaskShortDto toShortDto(Task task);
}
