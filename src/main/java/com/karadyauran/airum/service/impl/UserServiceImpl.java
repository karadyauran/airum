package com.karadyauran.airum.service.impl;

import com.karadyauran.airum.dto.UserDto;
import com.karadyauran.airum.dto.UserRegistrationDto;
import com.karadyauran.airum.error.EmailIsAlreadyExists;
import com.karadyauran.airum.error.UserWasNotFoundException;
import com.karadyauran.airum.error.UsernameIsAlreadyExists;
import com.karadyauran.airum.error.message.ErrorMessage;
import com.karadyauran.airum.mapper.UserMapper;
import com.karadyauran.airum.repository.UserRepository;
import com.karadyauran.airum.service.interf.UserService;
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
public class UserServiceImpl implements UserService
{
    UserRepository repository;
    UserMapper mapper;

    @Override
    @Transactional
    public UserDto getUserById(UUID id)
    {
        log.debug("Looking for the user with id {}", id);

        return mapper.toDto(
                repository.findById(id)
                        .orElseThrow(() ->
                                new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND)
                        )
        );
    }

    @Override
    @Transactional
    public UserDto getUserByUsername(String username)
    {
        log.debug("Looking for the user with username {}", username);

        return mapper.toDto(
                repository.findByUsername(username)
                        .orElseThrow(() ->
                                new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND)
                        )
        );
    }

    @Override
    @Transactional
    public List<UserDto> getAll()
    {
        log.debug("Looking for all users");

        return mapper.toDtoList(
                repository.findAll()
        );
    }

    @Override
    @Transactional
    public UserDto changeUsername(UUID id, String username)
    {
        if (userIsNotExists(id))
        {
            throw new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND);
        }

        if (checkUserByUsername(username))
        {
            throw new UsernameIsAlreadyExists(ErrorMessage.USERNAME_IS_ALREADY_EXISTS);
        }

        repository.changeUsername(id, username);
        return mapper.toDto(
                repository.findByUsername(username)
                        .orElse(null)
        );
    }

    @Override
    @Transactional
    public UserDto changeFirstname(UUID id, String firstname)
    {
        if (userIsNotExists(id))
        {
            throw new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND);
        }

        repository.changeFirstname(id, firstname);
        return mapper.toDto(
                repository.findById(id)
                        .orElse(null)
        );
    }

    @Override
    @Transactional
    public UserDto changeSurname(UUID id, String surname)
    {
        if (userIsNotExists(id))
        {
            throw new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND);
        }

        repository.changeSurname(id, surname);
        return mapper.toDto(
                repository.findById(id)
                        .orElse(null)
        );
    }

    @Override
    @Transactional
    public UserDto changeEmail(UUID id, String email)
    {
        if (userIsNotExists(id))
        {
            throw new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND);
        }

        if (!checkUserByEmail(email))
        {
            throw new EmailIsAlreadyExists(ErrorMessage.EMAIL_IS_ALREADY_EXISTS);
        }

        repository.changeEmail(id, email);
        return mapper.toDto(
                repository.findById(id)
                        .orElse(null)
        );
    }

    @Override
    @Transactional
    public void delete(UUID id)
    {
        if (userIsNotExists(id))
        {
            throw new UserWasNotFoundException(ErrorMessage.USER_WAS_NOT_FOUND);
        }

        repository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDto create(UserRegistrationDto dto)
    {
        log.debug("Saving new user {}", dto.getUsername());

        if (checkUserByUsername(dto.getUsername()))
        {
            throw new UsernameIsAlreadyExists(ErrorMessage.USERNAME_IS_ALREADY_EXISTS);
        }

        var entity = mapper.toEntity(dto);
        var saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    private boolean userIsNotExists(UUID id)
    {
        return !repository.existsById(id);
    }

    private boolean checkUserByUsername(String username)
    {
        return repository.findByUsername(username).orElse(null) != null;
    }

    private boolean checkUserByEmail(String email)
    {
        return repository.findByEmail(email).orElse(null) == null;
    }
}
