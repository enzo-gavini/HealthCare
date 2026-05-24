package com.enzo.patient.controller;


import com.enzo.patient.model.User;

import com.enzo.patient.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/findUserByUsername")
    public User getUserByUsername(@RequestParam String username) {
        return userService.findByUsername(username);
    }




}
