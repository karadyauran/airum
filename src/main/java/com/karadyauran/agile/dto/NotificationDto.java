package com.karadyauran.agile.dto;


import com.karadyauran.agile.dto.shortDto.UserNotificationShortDto;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
