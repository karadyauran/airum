package com.karadyauran.airum.service.impl;

import com.karadyauran.airum.dto.NotificationDto;
import com.karadyauran.airum.entity.Notification;
import com.karadyauran.airum.error.UserWasNotFoundException;
import com.karadyauran.airum.error.message.ErrorMessage;
import com.karadyauran.airum.mapper.NotificationMapper;
import com.karadyauran.airum.repository.NotificationRepository;
import com.karadyauran.airum.repository.UserRepository;
import com.karadyauran.airum.service.interf.NotificationService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class NotificationServiceImpl implements NotificationService
{
    NotificationRepository notificationRepository;
    UserRepository userRepository;

    NotificationMapper notificationMapper;

    @Override
    @Transactional
    public List<NotificationDto> getNotifications(UUID user1, UUID user2)
    {
        if (userIsNotExists(user1) || userIsNotExists(user2))
        {
            throw new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND);
        }

        return notificationMapper.toDtoList(
                notificationRepository
                        .findAllByIds(user1, user2)
        );
    }

    @Override
    @Transactional
    public NotificationDto send(Notification notification)
    {
        var sender = notification.getSender();
        var receiver = notification.getReceiver();

        if (userIsNotExists(receiver) || userIsNotExists(sender))
        {
            throw new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND);
        }

        notificationRepository.save(notification);
        return notificationMapper.toDto(notification);
    }

    private boolean userIsNotExists(UUID id)
    {
        return !userRepository.existsById(id);
    }
}
