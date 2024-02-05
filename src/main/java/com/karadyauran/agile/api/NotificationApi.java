package com.karadyauran.agile.api;

import com.karadyauran.agile.dto.NotificationDto;
import com.karadyauran.agile.entity.Notification;
import com.karadyauran.agile.validation.interf.Uuid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface NotificationApi
{
    @GetMapping("chat")
    ResponseEntity<List<NotificationDto>> getNotifications(@Uuid @RequestParam UUID user1, @Uuid @RequestParam UUID user2);

    @PostMapping("chat/send")
    ResponseEntity<NotificationDto> send(@RequestBody Notification notification);
}
