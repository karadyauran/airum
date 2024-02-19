package com.karadyauran.airum.dto;


import com.karadyauran.airum.dto.shortDto.UserNotificationShortDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto
{
    String message;
    UserNotificationShortDto sender;
    Timestamp sentAt;
}
