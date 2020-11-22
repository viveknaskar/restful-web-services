package com.viveknaskar.restfulwebservices.controller;

import com.viveknaskar.restfulwebservices.beans.User;
import com.viveknaskar.restfulwebservices.exceptions.UserNotFoundException;
import com.viveknaskar.restfulwebservices.services.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);
        if (user==null) {
            throw new UserNotFoundException("id: " + id);
        }
        return userDaoService.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user) {
        User createdUser = userDaoService.save(user);

        /** ServletUriComponentsBuilder extends UriComponentsBuilder.
         * So, ServletUriComponentsBuilder is UriComponentsBuilder with additional static factory methods
         * to create links based on the current HttpServletRequest.
         */
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userDaoService.deleteById(id);
        if (user==null) {
            throw new UserNotFoundException("id: " + id);
        }
    }

}
