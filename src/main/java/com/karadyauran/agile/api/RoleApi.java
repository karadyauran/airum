package com.karadyauran.agile.api;

import com.karadyauran.agile.dto.RoleDto;
import com.karadyauran.agile.entity.Role;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface RoleApi
{
    @GetMapping("role/{id}")
    ResponseEntity<RoleDto> getRoleById(@PathVariable UUID id);

    @GetMapping("role/all")
    ResponseEntity<List<RoleDto>> getRolesForProject(@RequestParam UUID project);

    @PostMapping("role/create")
    ResponseEntity<RoleDto> create(RoleDto role);

    @PutMapping("role/change-name")
    ResponseEntity<RoleDto> change(@RequestParam UUID id, @RequestParam String name);

    @DeleteMapping("role/delete/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);
}
