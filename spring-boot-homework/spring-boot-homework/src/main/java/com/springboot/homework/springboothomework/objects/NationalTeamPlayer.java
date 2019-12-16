package com.springboot.homework.springboothomework.objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NationalTeamPlayer extends Footballer {

    private TShirt countryTshirt = null;

    public NationalTeamPlayer(String name) {
        super(name);
    }

    @Autowired
    public String wears( final NationalTeamTshirt countryLogo) {

        this.countryTshirt = countryLogo;
        return this.getName() + " wears " + countryLogo.displays() + "'s colours.";

    }

    @Override
    public String toString() {

        return super.toString() + " plays for " + countryTshirt.displays();
    }

}
