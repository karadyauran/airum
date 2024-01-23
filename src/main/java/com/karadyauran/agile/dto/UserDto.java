package com.karadyauran.agile.dto;

import com.karadyauran.agile.entity.Project;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;

import java.util.List;

@Builder
@Tag(name = "User", description = "Dto for user")
public class UserDto
{
    @Schema(name = "Username", description = "Username for User, unique")
    String username;
    @Schema(name = "User firstname", description = "Firstname for User")
    String name;
    @Schema(name = "User surname", description = "Surname for User")
    String surname;
    @Schema(name = "Owned Projects", description = "Project user owned")
    List<Project> ownedProjects;
}
