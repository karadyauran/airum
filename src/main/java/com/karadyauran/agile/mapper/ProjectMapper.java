package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.NotificationDto;
import com.karadyauran.agile.dto.ProjectDto;
import com.karadyauran.agile.dto.UserDto;
import com.karadyauran.agile.entity.Notification;
import com.karadyauran.agile.entity.Project;
import com.karadyauran.agile.entity.User;
import com.karadyauran.agile.repository.UserRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface ProjectMapper
{
    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description"),
            @Mapping(target = "creator", expression = "java(mapSender(project.getCreatorId(), repository, userMapper))"),
            @Mapping(target = "createdAt", source = "createdAt")
    })
    ProjectDto toDto(
            Project project,
            @Context UserRepository repository,
            @Context UserMapper userMapper
    );

    default UserDto mapSender(UUID sender, UserRepository repository, UserMapper userMapper)
    {
        User user = repository.findById(sender).orElse(null);
        return user != null ? userMapper.toDto(user) : null;
    }

    @Mapping(target = "creator", source = "creator")
    List<ProjectDto> toDtoList(
            List<Project> projects,
            @Context UserRepository repository,
            @Context UserMapper userMapper
    );
}

