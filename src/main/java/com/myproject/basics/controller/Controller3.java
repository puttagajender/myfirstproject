package com.myproject.basics.controller;

import com.myproject.basics.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v3")
@RestController
public class Controller3 {
  Service service = new Service();
    @GetMapping("/hello")
    public String hello() {
        System.out.println("api/v3/hello called and hashcode is "+ service.hashCode());
        return service.getGreeting();
    }
}
