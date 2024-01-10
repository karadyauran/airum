package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.entity.Role;
import com.karadyauran.agile.repository.RoleRepository;
import com.karadyauran.agile.service.interf.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService
{
    private final RoleRepository roleRepository;

    @Override
    public Role getRoleById(String roleId)
    {
        return roleRepository.getRoleByRoleId(UUID.fromString(roleId));
    }
}
