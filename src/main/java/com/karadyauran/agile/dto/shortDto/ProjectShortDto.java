package com.karadyauran.agile.dto.shortDto;

import com.karadyauran.agile.dto.TaskDto;
import com.karadyauran.agile.entity.Task;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectShortDto
{
    String id;
    String name;
    String description;
    List<TaskDto> tasks;
    Timestamp createdAt;
}
