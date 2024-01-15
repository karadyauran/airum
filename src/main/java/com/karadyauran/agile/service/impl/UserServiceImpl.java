package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.entity.User;
import com.karadyauran.agile.repository.UserRepository;
import com.karadyauran.agile.service.interf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    @Override
    public User getUserById(String userId)
    {
        return userRepository.findUserByUserId(UUID.fromString(userId));
    }
}
