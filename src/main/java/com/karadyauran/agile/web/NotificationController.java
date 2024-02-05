package com.karadyauran.agile.web;

import com.karadyauran.agile.api.NotificationApi;
import com.karadyauran.agile.dto.NotificationDto;
import com.karadyauran.agile.entity.Notification;
import com.karadyauran.agile.service.interf.NotificationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NotificationController implements NotificationApi
{
    NotificationService service;

    @Override
    public ResponseEntity<List<NotificationDto>> getNotifications(UUID user1, UUID user2)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getNotifications(user1, user2));
    }

    @Override
    public ResponseEntity<NotificationDto> send(Notification notification)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.send(notification));
    }
}
