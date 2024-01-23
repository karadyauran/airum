package com.karadyauran.agile.dto;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Tag(name = "Role", description = "Dto for role")
public class RoleDto
{
    String roleName;
    String description;
}
