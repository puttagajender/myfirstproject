package com.myproject.basics.controller;

import com.myproject.basics.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api/v1")
@RestController
public class Controller1 {
    private final Service service;
    public Controller1(Service service) {
        this.service = service;
    }
    @GetMapping("/hello")
    public String hello() {
        System.out.println("api/v1/hello called and hashcode is "+ service.hashCode());
        return service.getGreeting();
    }
}
