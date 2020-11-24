package com.viveknaskar.restfulwebservices.controller;

import com.viveknaskar.restfulwebservices.beans.User;
import com.viveknaskar.restfulwebservices.exceptions.UserNotFoundException;
import com.viveknaskar.restfulwebservices.services.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        User user = userDaoService.findOne(id);
        if (user==null) {
            throw new UserNotFoundException("id: " + id);
        }

        /**
         * HATEOAS
         * "all-users", SERVER_PATH + "/users"
         * retrieveAllUsers
         */
        EntityModel<User> resource = EntityModel.of(user);

        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());

        // Returning a set of links
        resource.add(linkTo.withRel("all-users"));

        return resource;

    }

    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user) {
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
