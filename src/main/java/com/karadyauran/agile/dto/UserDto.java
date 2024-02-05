package com.karadyauran.agile.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.karadyauran.agile.dto.shortDto.ProjectShortDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    String id;
    String username;
    String firstname;
    String surname;
    String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;
    List<ProjectShortDto> projects;
}
