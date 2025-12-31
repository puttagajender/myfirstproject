package com.myproject.basics.service;

import com.myproject.basics.interfaces.LooselyCoupled;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("looselyCoupledB")
public class LooselyCoupledB implements LooselyCoupled {
    public String getMessage() {
        return "Hello from LooselyCoupledB";
    }
}
