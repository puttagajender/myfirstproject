package com.myproject.basics.controller;

import com.myproject.basics.interfaces.LooselyCoupled;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v4")
public class Controller4 {

    private final LooselyCoupled looselyCoupled;

    private final LooselyCoupled looselyCoupled2;

    public Controller4(LooselyCoupled primaryBean,@Qualifier("looselyCoupledB") LooselyCoupled qualifiedBean) {
        this.looselyCoupled = primaryBean;
        this.looselyCoupled2= qualifiedBean;
    }

    @GetMapping("/hello")
    public String hello() {
        return looselyCoupled.getMessage();
    }

    @GetMapping("/helloforB")
    public String helloForB() {
       return looselyCoupled2.getMessage();
    }


// @Primary and @Qualifier are annotations to used to resolve the ambiguity between bean which are implementations of same interface.
    // Annotation @Primary is used to give higher preference to a bean when multiple beans of same type are present.
    // Annotation @Qualifier is used to specify exactly which bean should be injected when multiple beans of same type are present.
    // In this example, LooselyCoupledA is marked as @Primary, so it will be injected by default.
    // LooselyCoupledB is injected using @Qualifier("looselyCoupledB") to specify that this particular bean should be used.
    // This way, we can control which implementation of LooselyCoupled interface is used in the controller.
    // This is useful in scenarios where different implementations provide different functionalities or behaviors.
    // Using @Primary and @Qualifier helps in achieving loose coupling and better manageability of dependencies in Spring applications.
    // Thus, we can easily switch between different implementations without changing the controller code.
    //Note:  Both annotations are come into picture when there are multiple beans of same type in the Spring context.


    @GetMapping("/conditionalBean")
    public String conditionalBeanDemo() {
        return "This is a demo for conditional bean creation.";
    }
}
