package com.viveknaskar.restfulwebservices.controller;

import com.viveknaskar.restfulwebservices.beans.WelcomeDeveloper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HomeController {

    @Autowired
    private MessageSource messageSource;

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

    @GetMapping(path = "/hello-developer-internationalized")
    public String helloDeveloperInternationalisation() {
        return messageSource.getMessage("morning.greetings", null, LocaleContextHolder.getLocale());
    }
}
