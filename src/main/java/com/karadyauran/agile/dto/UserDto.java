package com.karadyauran.agile.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


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
}
