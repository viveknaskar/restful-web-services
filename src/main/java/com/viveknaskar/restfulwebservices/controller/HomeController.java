package com.viveknaskar.restfulwebservices.controller;

import com.viveknaskar.restfulwebservices.beans.WelcomeDeveloperBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(path = "/welcome")
    public String welcomePage() {
        return "Hello Developer. Welcome to the world of RESTful web services.";
    }

    @GetMapping(path = "/welcome-developers")
    public WelcomeDeveloperBean welcomeDevelopers() {
        return new WelcomeDeveloperBean("Welcome Developers");
    }
}
