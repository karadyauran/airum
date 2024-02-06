package com.karadyauran.agile.api;

import com.karadyauran.agile.dto.UserDto;
import com.karadyauran.agile.validation.interf.Uuid;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;


public interface UserApi
{
    @GetMapping("user/{id}")
    ResponseEntity<UserDto> findById(@Uuid @PathVariable UUID id);

    @GetMapping("{username}")
    ResponseEntity<UserDto> findByIUsername(@Size(min = 5, max = 40) @PathVariable String username);

    @GetMapping("users")
    ResponseEntity<List<UserDto>> findAll();

    @PutMapping("user/change-username")
    ResponseEntity<UserDto> changeUsername(@RequestParam UUID id, @Size(max = 40) @RequestParam String username);

    @PutMapping("user/change-firstname")
    ResponseEntity<UserDto> changeFirstname(@RequestParam UUID id, @Size(max = 40) @RequestParam String firstname);

    @PutMapping("user/change-surname")
    ResponseEntity<UserDto> changeSurname(@RequestParam UUID id, @Size(max = 40) @RequestParam String surname);

    @PutMapping("user/change-email")
    ResponseEntity<UserDto> changeEmail(@RequestParam UUID id, @Email @RequestParam String email);

    @DeleteMapping("user/delete/{id}")
    ResponseEntity<Void> deleteById(@Uuid @PathVariable UUID id);

    @PostMapping("user/create")
    ResponseEntity<UserDto> create(@Valid @RequestBody UserDto dto);
}
