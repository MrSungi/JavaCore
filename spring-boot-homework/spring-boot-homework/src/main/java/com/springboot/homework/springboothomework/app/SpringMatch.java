package com.springboot.homework.springboothomework.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;



@Component
public class SpringMatch {

    @Autowired
    @Qualifier("customerService")

    public static void main(String[] args) {

        ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext-football.xml");
        SportsMan johnny = appCtx.getBean("johnny", Footballer.class );

        johnny.run( 75 );
        johnny.jump( 30 );

        Ball ball = appCtx.getBean("football", Football.class );

        johnny.shoot( ball );

        NationalTeamPlayer goetze = appCtx.getBean("goetze", NationalTeamPlayer.class );
        NationalTeamTshirt shirt = appCtx.getBean("dortmund", NationalTeamTshirt.class );

        goetze.jump( 56 );
        goetze.run( 120 );

        System.out.println( goetze.wears( shirt ));

        Football football = appCtx.getBean("football", Football.class );

        goetze.shoot( football );
        goetze.score( 4 );
    }

}
