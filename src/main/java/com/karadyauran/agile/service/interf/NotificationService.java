package com.karadyauran.agile.service.interf;

import com.karadyauran.agile.dto.NotificationDto;
import com.karadyauran.agile.entity.Notification;

import java.util.List;
import java.util.UUID;

public interface NotificationService
{
    List<NotificationDto> getNotifications(UUID user1, UUID user2);

    NotificationDto send(Notification notification);
}
