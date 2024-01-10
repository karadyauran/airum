package com.karadyauran.agile.controller.page;

import com.karadyauran.agile.entity.Role;
import com.karadyauran.agile.service.interf.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController
{
    private final RoleService roleService;

    @GetMapping("/{id}")
    public Role getTaskById(@PathVariable("id") String taskId) {
        return roleService.getRoleById(taskId);
    }
}
