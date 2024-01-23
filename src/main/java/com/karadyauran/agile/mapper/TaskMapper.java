package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.TaskDto;
import com.karadyauran.agile.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper
{
    TaskDto toDto(Task task);
}
