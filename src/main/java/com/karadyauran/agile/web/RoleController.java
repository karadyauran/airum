package com.karadyauran.agile.web;

import com.karadyauran.agile.api.RoleApi;
import com.karadyauran.agile.entity.Role;
import com.karadyauran.agile.service.interf.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RoleController implements RoleApi
{
    RoleService service;

    @Override
    public ResponseEntity<Role> getRoleById(UUID id)
    {
        return null;
    }

    @Override
    public ResponseEntity<Role> create(Role role)
    {
        return null;
    }

    @Override
    public ResponseEntity<Role> change(UUID id, String name)
    {
        return null;
    }

    @Override
    public void delete(UUID id)
    {

    }
}
