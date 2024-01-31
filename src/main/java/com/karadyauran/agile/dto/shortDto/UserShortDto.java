package com.karadyauran.agile.dto.shortDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserShortDto
{
    String id;
    String username;
    String firstname;
    String surname;
    String email;
}
