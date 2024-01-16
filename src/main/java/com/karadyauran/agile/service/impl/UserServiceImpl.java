package com.karadyauran.agile.service.impl;

import com.karadyauran.agile.entity.User;
import com.karadyauran.agile.repository.UserRepository;
import com.karadyauran.agile.service.interf.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public boolean deleteUser(String id)
    {
        return userRepository.deleteUserByUserId(UUID.fromString(id)) > 0;
    }

    @Override
    public User create(User user)
    {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public boolean updateUsername(String id, String username)
    {
        return userRepository.updateUsernameById(UUID.fromString(id), username) > 0;
    }
}
