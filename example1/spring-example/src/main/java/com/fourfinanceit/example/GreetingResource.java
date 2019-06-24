package com.fourfinanceit.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController("/hello")
public class GreetingResource {

    @Autowired
    GreetingService service;

    @GetMapping(value = "/greeting/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting(@PathVariable("name") String name) {
        return service.greeting(name);
    }

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
        return "hello";
    }
}