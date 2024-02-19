package com.karadyauran.airum.service.interf;

import com.karadyauran.airum.dto.NotificationDto;
import com.karadyauran.airum.entity.Notification;

import java.util.List;
import java.util.UUID;

public interface NotificationService
{
    List<NotificationDto> getNotifications(UUID user1, UUID user2);

    NotificationDto send(Notification notification);
}
