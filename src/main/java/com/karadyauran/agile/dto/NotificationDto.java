package com.karadyauran.agile.dto;

import com.karadyauran.agile.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@Tag(name = "Notification", description = "Dto for notification")
public class NotificationDto
{
    String message;
    User sender;
    User receiver;
}
