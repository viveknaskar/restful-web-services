package com.viveknaskar.restfulwebservices.controller;

import com.viveknaskar.restfulwebservices.beans.User;
import com.viveknaskar.restfulwebservices.services.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User retrieveUser(@PathVariable int userId) {
        return userDaoService.findOne(userId);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        User createdUser = userDaoService.save(user);
        return createdUser;

    }

}
