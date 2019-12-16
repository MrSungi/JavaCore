package com.springboot.homework.springboothomework.objects;

import com.springboot.homework.springboothomework.entities.Ball;
import com.springboot.homework.springboothomework.entities.BallPlayer;
import org.springframework.stereotype.Component;


@Component
public class Footballer implements BallPlayer {

    static Byte kickCount = 0;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Footballer( final String name ) {
        this.name = name;
    }

    // Shoot a.k.a "kick" in football
    @Override
    public long shoot(Ball ballObject) {
        System.out.println( "I am kicking a ball object!" );

        // Maybe the score count for later
        return ballObject.move( 0 );
    }

    // Shoot a.k.a "kick" in football, so pass a football now. Note no @Override
    public long shoot(Football ballObject) {

        kickCount++;
        System.out.println( "\"I am kicking a FIFA football!\" screams " + this.name +
                " passing the ball for " + kickCount + (( kickCount == 1 ) ? " time" : " times "));

        // Let's say each kick becomes stronger
        return (long) (ballObject.move( kickCount ) * 2.5);
    }

    @Override
    public void run(long time) {
        System.out.println( this.getName() + " is running for " + time + " seconds ");

    }

    @Override
    public void jump( int centimeters ) {
        System.out.println( this.getName() + " jumps " + centimeters + " cm. high. " );
    }

    // Additionally !
    public boolean score() {

        System.out.println( this.name + " has just scored " +
                shoot(new Ball() {
            @Override
            public long move(long meters) {

                // 11 meters
                return 11;
            }
        }) + " meters goal!" );

        return true;
    }

    // Additionally !
    public boolean score( long meters ) {
        System.out.println( this.name + " has just scored " +
                ( shoot( new Football() ) + meters ) + " meters goal!" );

        return true;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
