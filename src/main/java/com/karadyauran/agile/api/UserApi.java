package com.karadyauran.agile.api;

import com.karadyauran.agile.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


public interface UserApi
{
    @GetMapping("user/{id}")
    ResponseEntity<UserDto> findById(@PathVariable UUID id);

    @GetMapping("{username}")
    ResponseEntity<UserDto> findByIUsername(@PathVariable String username);

    @GetMapping("users")
    ResponseEntity<List<UserDto>> findAll();

    @PutMapping("user/change-username")
    ResponseEntity<UserDto> changeUsername(@RequestParam UUID id, @RequestParam String username);

    @PutMapping("user/change-firstname")
    ResponseEntity<UserDto> changeFirstname(@RequestParam UUID id, @RequestParam String firstname);

    @PutMapping("user/change-surname")
    ResponseEntity<UserDto> changeSurname(@RequestParam UUID id, @RequestParam String surname);

    @PutMapping("user/change-email")
    ResponseEntity<UserDto> changeEmail(@RequestParam UUID id, @RequestParam String email);

    @DeleteMapping("user/delete/{id}")
    ResponseEntity<Void> deleteById(@PathVariable UUID id);

    @PostMapping("user/create")
    ResponseEntity<UserDto> create(@RequestBody UserDto dto);
}
