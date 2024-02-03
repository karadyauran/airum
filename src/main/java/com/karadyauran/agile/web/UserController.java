package com.karadyauran.agile.web;

import com.karadyauran.agile.api.UserApi;
import com.karadyauran.agile.dto.UserDto;
import com.karadyauran.agile.service.interf.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController implements UserApi
{
    UserService service;

    @Override
    public ResponseEntity<UserDto> findById(UUID id)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getUserById(id));
    }

    @Override
    public ResponseEntity<UserDto> findByIUsername(String username)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getUserByUsername(username));
    }

    @Override
    public ResponseEntity<List<UserDto>> findAll()
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAll());
    }

    @Override
    public ResponseEntity<UserDto> changeUsername(UUID id, String username)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeUsername(id, username));
    }

    @Override
    public ResponseEntity<UserDto> changeFirstname(UUID id, String firstname)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeFirstname(id, firstname));
    }

    @Override
    public ResponseEntity<UserDto> changeSurname(UUID id, String surname)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeSurname(id, surname));
    }

    @Override
    public ResponseEntity<UserDto> changeEmail(UUID id, String email)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.changeEmail(id, email));
    }

    @Override
    public ResponseEntity<Void> deleteById(UUID id)
    {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserDto> create(UserDto dto)
    {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.create(dto));
    }
}
