package com.karadyauran.agile.dto.shortDto;

import com.karadyauran.agile.dto.UserDto;
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
    UserDto creator;
    String name;
    String description;
    Timestamp createdAt;
}
