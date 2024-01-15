package com.karadyauran.agile.controller.page;

import com.karadyauran.agile.entity.Notification;
import com.karadyauran.agile.service.interf.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController
{
    private final NotificationService notificationService;

    @GetMapping("/id={id}")
    public Notification getNotificationById(@PathVariable String id)
    {
        return notificationService.getNotificationById(id);
    }
}
