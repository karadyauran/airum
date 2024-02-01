package com.karadyauran.agile.dto;

import lombok.*;

import java.sql.Timestamp;

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
