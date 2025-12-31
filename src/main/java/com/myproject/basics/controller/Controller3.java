package com.myproject.basics.controller;

import com.myproject.basics.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v3")
@RestController
public class Controller3 {
  Service service = new Service();
  //here we are not using DI, we are creating the object inside the class itself. Which causes tight coupling as the class is now dependent on the Service class implementation.
    // And also we cannot change the implementation of Service class without changing the Controller3 class.
    // And also we cannot mock the Service class for unit testing the Controller3 class.
    // Hence this approach is not recommended.
    // Also the hashcode will be different for each call as a new object is created each time.
    // As we are using new keyword to create the object inside the class which makes it tightly coupled.
    // Loosely coupled means the class is not dependent on the implementation of the other class.
    // Eg: When requirements change, which code breaks?
  //If controller breaks → ❌ NOT loose-coupled
  //If only service changes → ✅ loose-coupled
    //Using Controller class 4 we are going to demonstrate the loosely coupled approach using DI.
    @GetMapping("/hello")
    public String hello() {
        System.out.println("api/v3/hello called and hashcode is "+ System.identityHashCode(service));
        return service.getGreeting();
    }
}
