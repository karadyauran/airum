package com.karadyauran.agile.service.interf;

import com.karadyauran.agile.entity.User;

import java.util.List;

public interface UserService
{
    User getUserById(String id);

    List<User> findAll();

    boolean deleteUser(String id);

    User create(User user);

    boolean updateUsername(String id, String username);
}
