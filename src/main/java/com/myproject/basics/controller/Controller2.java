package com.myproject.basics.controller;

import com.myproject.basics.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v2")
@RestController
public class Controller2 {
    private final Service service;
    public Controller2(Service service) {
        this.service = service;
    }
    @GetMapping("/hello")
    public String hello() {
        System.out.println("api/v2/hello called and hashcode is "+System.identityHashCode(service));
        return service.getGreeting();
    }
}
