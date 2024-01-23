package com.karadyauran.agile.controller.page;

import com.karadyauran.agile.dto.UserDto;
import com.karadyauran.agile.entity.User;
import com.karadyauran.agile.service.interf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    @GetMapping("/")
    public UserDto getUserById(@RequestParam String id)
    {
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public List<User> getAllUsers()
    {
        return userService.findAll();
    }

    @PostMapping("/create")
    public User create(@RequestBody User user)
    {
        return userService.create(user);
    }

    @PutMapping("/update/")
    public String updateUsername(@RequestParam String id, @RequestParam String username)
    {
        boolean success = userService.updateUsername(id, username);
        return success ? "Username was successfully updated" : "Failed to update username";
    }

    @DeleteMapping("delete/id={id}")
    public String deleteUser(@PathVariable String id)
    {
        boolean success = userService.deleteUser(id);
        return success ? "User was successfully deleted" : "User wasn't deleted";
    }
}
