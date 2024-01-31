package com.karadyauran.agile.dto.shortDto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectShortDto
{
    String id;
    String name;
    String description;
    Timestamp createdAt;
}
