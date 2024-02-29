package com.karadyauran.airum.web;

import com.karadyauran.airum.api.NotificationApi;
import com.karadyauran.airum.dto.NotificationDto;
import com.karadyauran.airum.entity.Notification;
import com.karadyauran.airum.service.interf.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Get Notifications between Users",
            description = "Fetches notifications exchanged between two specified users.",
            tags = { "NOTIFICATIONS" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Notifications found",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = NotificationDto.class)))),
                    @ApiResponse(responseCode = "404", description = "No notifications found")
            })
    @Override
    public ResponseEntity<List<NotificationDto>> getNotifications(UUID user1, UUID user2)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getNotifications(user1, user2));
    }

    @Operation(summary = "Send Notification",
            description = "Sends a new notification from one user to another.",
            tags = { "NOTIFICATIONS" },
            requestBody = @RequestBody(description = "Notification details", required = true,
                    content = @Content(schema = @Schema(implementation = NotificationDto.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Notification sent successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid notification details")
            })
    @Override
    public ResponseEntity<NotificationDto> send(Notification notification)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.send(notification));
    }
}
