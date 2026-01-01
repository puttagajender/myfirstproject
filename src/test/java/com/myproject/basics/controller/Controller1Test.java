package com.myproject.basics.controller;

import com.myproject.basics.config.AppConfig;
import com.myproject.basics.service.Service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
@ExtendWith(MockitoExtension.class)
public class Controller1Test {

    @Mock
    private Service service;
    @Mock
    private AppConfig config;
    @Test
    public void testHello() {

Controller1 controller = new Controller1(service, config);
        Mockito.when(service.getGreeting()).thenReturn("Hello, World!");
        String response = controller.hello();
      assert(response.equals("Hello, World!"));
    }
}
