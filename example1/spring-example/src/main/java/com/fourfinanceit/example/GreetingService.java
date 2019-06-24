package com.fourfinanceit.example;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String greeting(String name) {
        return "hello " + name;
    }

}
