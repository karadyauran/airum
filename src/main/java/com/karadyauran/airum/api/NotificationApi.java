package com.karadyauran.airum.api;

import com.karadyauran.airum.dto.NotificationDto;
import com.karadyauran.airum.entity.Notification;
import com.karadyauran.airum.validation.interf.Uuid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

public interface NotificationApi
{
    @GetMapping("chat")
    ResponseEntity<List<NotificationDto>> getNotifications(@Uuid @RequestParam UUID user1, @Uuid @RequestParam UUID user2);

    @PostMapping("chat/send")
    ResponseEntity<NotificationDto> send(@RequestBody Notification notification);
}
