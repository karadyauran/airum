package com.karadyauran.agile.api;

import com.karadyauran.agile.entity.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

public interface RoleApi
{
    @GetMapping("role/{id}")
    ResponseEntity<Role> getRoleById(@PathVariable UUID id);

    @PostMapping("role/create")
    ResponseEntity<Role> create(Role role);

    @PutMapping("role/change-name")
    ResponseEntity<Role> change(@RequestParam UUID id, @RequestParam String name);

    @DeleteMapping("delete/{id}")
    void delete(@PathVariable UUID id);
}
