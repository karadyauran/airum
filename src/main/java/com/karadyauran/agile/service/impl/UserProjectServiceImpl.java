package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.dto.RoleDto;
import com.karadyauran.agile.error.ProjectWasNotFoundException;
import com.karadyauran.agile.error.RoleWasNotFoundException;
import com.karadyauran.agile.error.UserWasNotFoundException;
import com.karadyauran.agile.error.message.ErrorMessage;
import com.karadyauran.agile.mapper.RoleMapper;
import com.karadyauran.agile.repository.ProjectRepository;
import com.karadyauran.agile.repository.RoleRepository;
import com.karadyauran.agile.repository.UserProjectRepository;
import com.karadyauran.agile.repository.UserRepository;
import com.karadyauran.agile.service.interf.UserProjectService;
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
public class UserProjectServiceImpl implements UserProjectService
{
    UserProjectRepository userProjectRepository;
    UserRepository userRepository;
    ProjectRepository projectRepository;
    RoleRepository roleRepository;

    RoleMapper roleMapper;

    @Override
    public RoleDto getRole(UUID userId, UUID projectId)
    {
        if (userIsNotExists(userId))
        {
            throw new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND);
        }

        if (projectIsNotExists(projectId))
        {
            throw new ProjectWasNotFoundException(ErrorMessage.PROJECT_WAS_NOT_FOUND);
        }

        var userProj = userProjectRepository.findRoleForUser(userId, projectId);
        return roleMapper.toDto(
                roleRepository.findById(userProj.getRoleId())
                        .orElseThrow(() -> new RoleWasNotFoundException(ErrorMessage.ROLE_WAS_NOT_FOUND))
        );
    }

    private boolean userIsNotExists(UUID id)
    {
        return !userRepository.existsById(id);
    }

    private boolean projectIsNotExists(UUID id)
    {
        return !projectRepository.existsById(id);
    }
}
