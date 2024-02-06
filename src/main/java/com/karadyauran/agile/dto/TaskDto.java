package com.karadyauran.agile.dto;

import com.karadyauran.agile.dto.shortDto.UserShortDto;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto
{
    String title;
    String description;
    UserShortDto assignedTo;
    UserShortDto createdBy;
    Date dueTo;
}
