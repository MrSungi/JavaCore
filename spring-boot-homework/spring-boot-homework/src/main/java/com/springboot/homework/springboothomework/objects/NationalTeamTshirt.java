package com.springboot.homework.springboothomework.objects;

import org.springframework.stereotype.Component;

@Component
public class NationalTeamTshirt extends TShirt {

    public NationalTeamTshirt( final String logo ) {
        super.logo = logo;
    }

    @Override
    public String displays() {
        return this.logo;

    }

    public void setLogo(String logo) {
        super.logo = logo;
    }
}
