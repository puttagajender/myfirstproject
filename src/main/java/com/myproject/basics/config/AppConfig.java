package com.myproject.basics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration
//Configuration = @ComponentScan + extra behaviour
//extra behaviour means, whenever a class is annotated with @Configuration and has @Bean methods that return spring managed bean otherwise it will create only new methods like tight coupled
// When you annotate a class with @Configuration, Spring treats it as a source of bean definitions.
@Configuration
public class AppConfig {

   /* @Component
    class AppConfig {

        @Bean
        public A a() {
            return new A();
        }

        @Bean
        public B b() {
            return new B(a()); // ❌ creates NEW A
        }
    }*/

    @Bean
    public AppConfig a() {
        return new AppConfig();
    }
    public String b() {
        return new String("Hello");
    }
}
