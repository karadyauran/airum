package com.karadyauran.agile.service.interf;

import com.karadyauran.agile.dto.RoleDto;

import java.util.UUID;

public interface UserProjectService
{
    RoleDto getRole(UUID userId, UUID projectId);
}
