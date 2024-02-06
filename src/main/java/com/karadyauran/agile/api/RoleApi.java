package com.karadyauran.agile.api;

import com.karadyauran.agile.dto.RoleDto;
import com.karadyauran.agile.entity.Role;
import com.karadyauran.agile.validation.interf.Uuid;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public interface RoleApi
{
    @GetMapping("role/{id}")
    ResponseEntity<RoleDto> getRoleById(@Uuid @PathVariable UUID id);

    @GetMapping("role/all")
    ResponseEntity<List<RoleDto>> getRolesForProject(@Uuid @RequestParam UUID project);

    @PostMapping("role/create")
    ResponseEntity<RoleDto> create(Role role);

    @PutMapping("role/change-name")
    ResponseEntity<RoleDto> change(@Uuid @RequestParam UUID id, @Size(min = 2, max = 20) @RequestParam String name);

    @DeleteMapping("role/delete/{id}")
    ResponseEntity<Void> delete(@Uuid @PathVariable UUID id);
}
