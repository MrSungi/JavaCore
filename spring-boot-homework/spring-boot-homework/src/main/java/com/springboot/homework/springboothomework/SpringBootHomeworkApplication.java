package com.springboot.homework.springboothomework;

import com.springboot.homework.springboothomework.entities.Ball;
import com.springboot.homework.springboothomework.entities.SportsMan;
import com.springboot.homework.springboothomework.objects.Football;
import com.springboot.homework.springboothomework.objects.Footballer;
import com.springboot.homework.springboothomework.objects.NationalTeamPlayer;
import com.springboot.homework.springboothomework.objects.NationalTeamTshirt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringBootHomeworkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHomeworkApplication.class, args);




		ApplicationContext appCtx = new ClassPathXmlApplicationContext("applicationContext-football.xml");
		Footballer johnny = appCtx.getBean("johnny", Footballer.class );

		johnny.run( 75 );
		johnny.jump( 30 );

		Football ball = appCtx.getBean("football", Football.class );

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

	@Override
	public void run(String... args) throws Exception {

	}
}
