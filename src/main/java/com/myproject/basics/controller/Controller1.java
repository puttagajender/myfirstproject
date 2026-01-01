package com.myproject.basics.controller;

import com.myproject.basics.config.AppConfig;
import com.myproject.basics.service.Service;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor

public class Controller1 {
    private final Service service;
    private final AppConfig appConfig;

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
        System.out.println("AppConfig identityhashcode in controller1: "+ System.identityHashCode(appConfig));
        return service.getGreeting();
    }

    /*
    1️⃣ @Transactional

Example:
In a banking app, transferring money involves debiting one account and crediting another.
If credit fails after debit, Spring rolls back everything so money is not lost.

👉 Use when multiple DB operations must succeed or fail together.

2️⃣ @Retryable

Example:
Your service calls an external payment gateway.
The first call fails due to a temporary network issue, so Spring automatically retries the call instead of failing immediately.

👉 Use for temporary failures (network, timeout, 5xx errors).

3️⃣ @Async

Example:
After a user places an order, you send an email notification.
The user should not wait for the email to be sent, so Spring runs it in the background.

👉 Use when the result is not needed immediately.

4️⃣ @CircuitBreaker

Example:
Your app calls a third-party customer API that is currently down.
After repeated failures, Spring stops calling it for some time to protect your system.

👉 Use to prevent cascading failures and system overload.

5️⃣ @Cacheable

Example:
Fetching user profile details from DB that rarely change.
Spring stores the result and returns it from cache for repeated requests instead of hitting the DB every time.

👉 Use to improve performance for repeated reads.

One-line master takeaway (important)

All these annotations use AOP to add reusable behavior around your methods without changing your business logic
     */
}
