package com.karadyauran.agile.dto.shortDto;

import com.karadyauran.agile.entity.Role;
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
    // TODO: fix nullable
    Role role;
}
