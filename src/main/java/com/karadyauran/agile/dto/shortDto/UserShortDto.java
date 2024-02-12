package com.karadyauran.agile.dto.shortDto;

import com.karadyauran.agile.dto.RoleDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class UserShortDto
{
    String username;
    RoleDto role;
}
