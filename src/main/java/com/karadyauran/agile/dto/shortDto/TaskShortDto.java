package com.karadyauran.agile.dto.shortDto;

import lombok.*;

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
