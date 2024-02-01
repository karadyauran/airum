package com.karadyauran.agile.dto;

import com.karadyauran.agile.dto.shortDto.UserShortDto;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto
{
    String id;
    // UserShortDto creator;
    String name;
    String description;
    // List<UserShortDto> users;
    // List<TaskDto> tasks;
    Timestamp createdAt;
}
