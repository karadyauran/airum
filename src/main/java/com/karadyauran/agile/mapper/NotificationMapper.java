package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.NotificationDto;
import com.karadyauran.agile.dto.UserDto;
import com.karadyauran.agile.entity.Notification;
import com.karadyauran.agile.entity.User;
import com.karadyauran.agile.repository.UserRepository;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface NotificationMapper
{

    @Mappings({
            @Mapping(target = "message", source = "message"),
            @Mapping(target = "sender", expression = "java(mapSender(notification.getSender(), repository, userMapper))"),
            @Mapping(target = "createdAt", source = "createdAt")
    })
    NotificationDto toDto(
            Notification notification,
            @Context UserRepository repository,
            @Context UserMapper userMapper
    );

    default UserDto mapSender(UUID sender, UserRepository repository, UserMapper userMapper)
    {
        User user = repository.findById(sender).orElse(null);
        return user != null ? userMapper.toDto(user) : null;
    }

    @Mapping(target = "sender", source = "sender")
    List<NotificationDto> toDtoList(
            List<Notification> notifications,
            @Context UserRepository repository,
            @Context UserMapper userMapper
    );
}

