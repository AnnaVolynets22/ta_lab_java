package com.epam.lab.game.warriors;

import com.epam.lab.game.constants.Constants;

public class Samurai extends Warrior {

    public Samurai() {
        super("Samurai", Constants.SAMURAI_HEALTH, Constants.SAMURAI_MAX_BLOCK);
    }

    public Samurai(String name) {
        super(name, Constants.SAMURAI_HEALTH, Constants.SAMURAI_MAX_BLOCK);
    }

}
