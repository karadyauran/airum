package com.karadyauran.airum.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.karadyauran.airum.dto.shortDto.ProjectShortDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto
{
    String id;
    @Size(max = 40)
    String username;
    @Size(max = 40)
    String firstname;
    @Size(max = 40)
    String surname;
    @Email(message = "Email is not valid")
    String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;
    List<ProjectShortDto> projects;
}
