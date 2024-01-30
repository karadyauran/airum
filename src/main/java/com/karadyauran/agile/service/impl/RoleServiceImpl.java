package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.entity.Role;
import com.karadyauran.agile.error.RoleIsAlreadyExists;
import com.karadyauran.agile.error.RoleWasNotFoundException;
import com.karadyauran.agile.error.message.ErrorMessage;
import com.karadyauran.agile.repository.RoleRepository;
import com.karadyauran.agile.service.interf.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RoleServiceImpl implements RoleService
{
    RoleRepository repository;

    @Override
    public Role getRole(UUID id)
    {
        return repository.findById(id)
                .orElseThrow(() -> new RoleWasNotFoundException(ErrorMessage.ROLE_WAS_NOT_FOUND));
    }

    @Override
    public Role create(Role role)
    {
        var name = role.getName();

        if (checkRoleByName(name))
        {
            return repository.findByName(name).orElse(null);
        }

        repository.save(role);
        return repository.findByName(name).orElse(null);
    }

    @Override
    public Role change(UUID id, String name)
    {
        if (checkRoleById(id))
        {
            throw new RoleWasNotFoundException(ErrorMessage.ROLE_WAS_NOT_FOUND);
        }

        if (checkRoleByName(name))
        {
            throw new RoleIsAlreadyExists(ErrorMessage.ROLE_IS_ALREADY_EXISTS);
        }

        repository.changeName(id, name);
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(UUID id)
    {
        if (checkRoleById(id))
        {
            throw new RoleWasNotFoundException(ErrorMessage.ROLE_WAS_NOT_FOUND);
        }

        repository.deleteById(id);
    }

    private boolean checkRoleById(UUID id)
    {
        return repository.findById(id).orElse(null) == null;
    }

    private boolean checkRoleByName(String name)
    {
        return repository.findByName(name).orElse(null) != null;
    }
}
