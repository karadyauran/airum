package com.karadyauran.agile.dto.shortDto;

import com.karadyauran.agile.dto.RoleDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserShortDto
{
    String username;
    RoleDto role;
}
