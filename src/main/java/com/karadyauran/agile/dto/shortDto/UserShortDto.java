package com.karadyauran.agile.dto.shortDto;

import com.karadyauran.agile.dto.RoleDto;
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
public class UserShortDto
{
    String username;
    RoleDto role;
}
