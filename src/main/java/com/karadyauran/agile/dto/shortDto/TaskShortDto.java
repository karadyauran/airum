package com.karadyauran.agile.dto.shortDto;

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
public class TaskShortDto
{
    String title;
    UserShortDto assignedTo;
    UserShortDto createdBy;
    Date dueTo;
}
