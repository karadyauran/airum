package com.karadyauran.agile.dto.shortDto;

import com.karadyauran.agile.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
