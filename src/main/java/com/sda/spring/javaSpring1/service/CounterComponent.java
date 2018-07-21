package com.sda.spring.javaSpring1.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CounterComponent {

    private int counter = 0;

    public int increment(){
        return ++counter;
    }



}
