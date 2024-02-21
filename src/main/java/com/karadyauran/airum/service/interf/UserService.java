package com.karadyauran.airum.service.interf;

import com.karadyauran.airum.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService
{
    UserDto getUserById(UUID id);

    UserDto getUserByUsername(String username);

    List<UserDto> getAll();

    UserDto changeUsername(UUID id, String username);

    UserDto changeFirstname(UUID id, String firstname);

    UserDto changeSurname(UUID id, String surname);

    UserDto changeEmail(UUID id, String email);

    void delete(UUID id);

    UserDto create(UserDto dto);
}
