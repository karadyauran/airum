package com.karadyauran.agile.service.interf;

import com.karadyauran.agile.entity.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService
{
    Role getRole(UUID id);

    List<Role> getAllRolesForProject(UUID projectId);

    Role create(Role role);

    Role change(UUID id, String name);

    void delete(UUID id);
}
