package com.myproject.basics.service;

import com.myproject.basics.interfaces.LooselyCoupled;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service

public class LooselyCoupledA implements LooselyCoupled {

    public String getMessage() {
        return "Hello from LooselyCoupledA";
    }

}
