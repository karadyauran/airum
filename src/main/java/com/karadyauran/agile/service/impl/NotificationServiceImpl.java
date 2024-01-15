package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.entity.Notification;
import com.karadyauran.agile.repository.NotificationRepository;
import com.karadyauran.agile.service.interf.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService
{
    private final NotificationRepository notificationRepository;

    @Override
    public Notification getNotificationById(String id)
    {
        return notificationRepository.findNotificationByNotificationId(UUID.fromString(id));
    }
}
