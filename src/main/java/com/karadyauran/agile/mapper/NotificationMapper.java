package com.karadyauran.agile.mapper;

import com.karadyauran.agile.dto.NotificationDto;
import com.karadyauran.agile.entity.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper
{
    NotificationDto toDto(Notification notification);
}
