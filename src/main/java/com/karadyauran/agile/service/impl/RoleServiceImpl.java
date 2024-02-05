package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.dto.RoleDto;
import com.karadyauran.agile.entity.Role;
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
    public RoleDto create(Role role)
    {
        repository.save(role);
        return mapper.toDto(role);
    }

    @Override
    @Transactional
    public RoleDto change(UUID id, String name)
    {
        if (roleIsNotExists(id))
        {
            throw new RoleWasNotFoundException(ErrorMessage.ROLE_WAS_NOT_FOUND);
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
        if (roleIsNotExists(id))
        {
            throw new RoleWasNotFoundException(ErrorMessage.ROLE_WAS_NOT_FOUND);
        }

        repository.deleteById(id);
    }

    private boolean roleIsNotExists(UUID id)
    {
        return !repository.existsById(id);
    }
}

