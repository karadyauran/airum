package com.karadyauran.agile.dto;

import com.karadyauran.agile.dto.shortDto.UserShortDto;
import com.karadyauran.agile.entity.Task;
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
    UserDto creator;
    String name;
    String description;
    List<UserShortDto> users;
    List<Task> tasks;
    Timestamp createdAt;
}
