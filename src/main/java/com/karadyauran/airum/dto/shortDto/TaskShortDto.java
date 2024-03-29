package com.karadyauran.airum.dto.shortDto;

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
public class TaskShortDto
{
    String id;
    String title;
    UserShortDto assignedTo;
    UserShortDto createdBy;
    Date dueTo;
}
