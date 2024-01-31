package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.dto.NotificationDto;
import com.karadyauran.agile.entity.Notification;
import com.karadyauran.agile.error.UserWasNotFoundException;
import com.karadyauran.agile.error.message.ErrorMessage;
import com.karadyauran.agile.mapper.NotificationMapper;
import com.karadyauran.agile.mapper.UserMapper;
import com.karadyauran.agile.repository.NotificationRepository;
import com.karadyauran.agile.repository.UserRepository;
import com.karadyauran.agile.service.interf.NotificationService;
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
    UserMapper userMapper;

    @Override
    public List<NotificationDto> getNotifications(UUID user1, UUID user2)
    {
        if (checkUser(user1) || checkUser(user2))
        {
            throw  new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND);
        }

        return notificationMapper.toDtoList(
                notificationRepository
                        .findAllByIds(user1, user2),
                userRepository,
                userMapper
        );
    }

    @Override
    public NotificationDto send(Notification notification)
    {
        var sender = notification.getSender();
        var receiver = notification.getReceiver();

        if (checkUser(receiver) || checkUser(sender))
        {
            throw  new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND);
        }

        notificationRepository.save(notification);
        return notificationMapper.toDto(notification, userRepository, userMapper);
    }

    private boolean checkUser(UUID id)
    {
        return userRepository.findById(id).orElse(null) == null;
    }
}
