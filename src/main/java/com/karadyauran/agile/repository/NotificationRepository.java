package com.karadyauran.agile.repository;

import com.karadyauran.agile.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID>
{
    Notification findNotificationByNotificationId(UUID id);
}
