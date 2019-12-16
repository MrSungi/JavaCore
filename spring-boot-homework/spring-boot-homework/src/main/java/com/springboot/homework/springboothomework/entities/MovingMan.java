package com.springboot.homework.springboothomework.entities;

public interface MovingMan extends ModelMan {

    public void run( long time );
    public void jump( int cm );
}
