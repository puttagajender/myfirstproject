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
        System.out.println("api/v1/hello called and hashcode is "+ System.identityHashCode(service));
        //“DI means supplying required object references from outside the class”
        //Dependency = object reference
        //Method call = usage of dependency
/*        System.identityHashCode(obj)
        Final

        Cannot be overridden

        JVM-level identity

        Tied to actual object reference
        note: Hashcode also will be same for same bean which is used in multiple classes, but it can be overridden by java developer*/

  /*
| Benefit             | Importance |
| ------------------- | ---------- |
| Loose coupling      | ⭐⭐⭐⭐⭐      |
| Testability         | ⭐⭐⭐⭐⭐      |
| Clean design (SRP)  | ⭐⭐⭐⭐       |
| Config-based wiring | ⭐⭐⭐⭐       |
| Lifecycle & AOP     | ⭐⭐⭐⭐       |
| Same instance reuse | ⭐⭐         |
*/
        return service.getGreeting();
    }
}
