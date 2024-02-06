package com.karadyauran.agile.dto;

import com.karadyauran.agile.dto.shortDto.TaskShortDto;
import com.karadyauran.agile.dto.shortDto.UserShortDto;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
    String name;
    String description;
    List<UserShortDto> members;
    List<TaskShortDto> tasks;
    Timestamp createdAt;
}
