package com.karadyauran.airum.dto;

import com.karadyauran.airum.dto.shortDto.TaskShortDto;
import com.karadyauran.airum.dto.shortDto.UserShortDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
