package com.epam.lab.game.warriors;

import com.epam.lab.game.constants.Constants;

public class Spartan extends Warrior {
    public Spartan() {
        super("Spartan", Constants.SPARTAN_HEALTH, Constants.SAMURAI_MAX_BLOCK);
    }

    public Spartan(String name) {
        super(name, Constants.SPARTAN_HEALTH, Constants.SAMURAI_MAX_BLOCK);
    }
}
