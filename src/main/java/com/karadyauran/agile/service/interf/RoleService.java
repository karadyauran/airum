package com.karadyauran.agile.service.interf;

import com.karadyauran.agile.dto.RoleDto;
import com.karadyauran.agile.entity.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService
{
    RoleDto getRole(UUID id);

    List<RoleDto> getAllRolesForProject(UUID projectId);

    RoleDto create(Role role);

    RoleDto change(UUID id, String name);

    void delete(UUID id);
}
