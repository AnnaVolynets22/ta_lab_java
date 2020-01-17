package com.epam.lab.game.warriors;

import com.epam.lab.game.constants.Constants;

public class Ninja extends Warrior {
    public Ninja() {
        super("Ninja", Constants.NINJA_HEALTH, Constants.NINJA_MAX_BLOCK);
    }

    public Ninja(String name) {
        super(name, Constants.NINJA_HEALTH, Constants.NINJA_MAX_BLOCK);
    }
}
