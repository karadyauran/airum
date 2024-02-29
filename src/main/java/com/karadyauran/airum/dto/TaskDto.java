package com.karadyauran.airum.dto;

import com.karadyauran.airum.dto.shortDto.UserShortDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto
{
    String id;
    String title;
    String description;
    UserShortDto assignedToUser;
    UserShortDto createdByUser;
    Date dueTo;
}
