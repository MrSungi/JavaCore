package com.springboot.homework.springboothomework.objects;

import com.springboot.homework.springboothomework.entities.Ball;
import org.springframework.stereotype.Component;


@Component
public class Football implements Ball {

    @Override
    public long move(long meters) {

        System.out.printf("Ball moves " + meters + " m. ");
        return meters;
    }

}
