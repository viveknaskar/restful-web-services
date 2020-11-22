package com.viveknaskar.restfulwebservices.controller;

import com.viveknaskar.restfulwebservices.beans.WelcomeDeveloper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(path = "/welcome")
    public String welcomePage() {
        return "Hello Developer. Welcome to the world of RESTful web services.";
    }

    @GetMapping(path = "/welcome-developers")
    public WelcomeDeveloper welcomeDevelopers() {
        return new WelcomeDeveloper("Welcome Developers");
    }

    @GetMapping(path = "/welcome-developers/{name}")
    public WelcomeDeveloper welcomeDeveloper(@PathVariable String name) {
        return new WelcomeDeveloper(String.format("Welcome %s", name));
    }
}
