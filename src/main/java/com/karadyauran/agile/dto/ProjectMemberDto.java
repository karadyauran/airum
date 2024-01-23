package com.karadyauran.agile.dto;

import com.karadyauran.agile.entity.Role;
import com.karadyauran.agile.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Tag(name = "Project member", description = "Dto for project member")
public class ProjectMemberDto
{
    User user;
    Role role;
}
