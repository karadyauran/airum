package com.karadyauran.agile.controller.page;

import com.karadyauran.agile.entity.User;
import com.karadyauran.agile.service.interf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    @GetMapping("/id={id}")
    public User getUserById(@PathVariable String id)
    {
        return userService.getUserById(id);
    }
}
