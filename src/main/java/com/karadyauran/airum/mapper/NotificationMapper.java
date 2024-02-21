package com.karadyauran.airum.mapper;

import com.karadyauran.airum.dto.NotificationDto;
import com.karadyauran.airum.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface NotificationMapper
{

    @Mappings({
            @Mapping(target = "message", source = "message"),
            @Mapping(target = "sender", source = "senderUser"),
    })
    NotificationDto toDto(Notification notification);

    @Mapping(target = "sender", source = "sender")
    List<NotificationDto> toDtoList(List<Notification> notifications);
}

