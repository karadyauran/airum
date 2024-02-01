package com.karadyauran.agile.dto.shortDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskShortDto
{
    String title;
    String description;
    UserShortDto assignedTo;
}
