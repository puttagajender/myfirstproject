package com.myproject.basics.controller;

import com.myproject.basics.config.AppConfig;
import com.myproject.basics.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v2")
@RestController
public class Controller2 {
    private final Service service;
    private final AppConfig appConfig;
    public Controller2(Service service, AppConfig appConfig) {
        this.service = service;
        this.appConfig = appConfig;
    }
    @GetMapping("/hello")
    public String hello() {
        System.out.println("api/v2/hello called and hashcode is "+System.identityHashCode(service));
        System.out.println("AppConfig identityhashcode in controller2: "+ System.identityHashCode(appConfig));
        return service.getGreeting();
    }
}
