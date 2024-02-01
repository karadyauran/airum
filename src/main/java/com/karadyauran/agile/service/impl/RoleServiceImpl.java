package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.dto.RoleDto;
import com.karadyauran.agile.error.RoleIsAlreadyExists;
import com.karadyauran.agile.error.RoleWasNotFoundException;
import com.karadyauran.agile.error.message.ErrorMessage;
import com.karadyauran.agile.mapper.RoleMapper;
import com.karadyauran.agile.repository.RoleRepository;
import com.karadyauran.agile.service.interf.RoleService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RoleServiceImpl implements RoleService
{
    RoleRepository repository;
    RoleMapper mapper;

    @Override
    public RoleDto getRole(UUID id)
    {
        return mapper.toDto(
                repository.findById(id)
                        .orElseThrow(() -> new RoleWasNotFoundException(ErrorMessage.ROLE_WAS_NOT_FOUND))
        );
    }

    @Override
    public List<RoleDto> getAllRolesForProject(UUID projectId)
    {
        // verify project id
        return mapper.toDtoList(
                repository.findByProjectId(projectId)
        );
    }

    @Override
    public RoleDto create(RoleDto role)
    {
        var entity = mapper.toEntity(role);
        repository.save(entity);
        return role;
    }

    @Override
    @Transactional
    public RoleDto change(UUID id, String name)
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
        return mapper.toDto(
                repository.findById(id).orElse(null)
        );
    }

    @Override
    @Transactional
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
