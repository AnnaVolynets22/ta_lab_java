package com.epam.lab.game.warriors;

import com.epam.lab.game.constants.Constants;

public class Roman extends Warrior {
    public Roman() {
        super("Roman", Constants.ROMAN_HEALTH, Constants.ROMAN_MAX_BLOCK);
    }

    public Roman(String name) {
        super(name, Constants.ROMAN_HEALTH, Constants.ROMAN_MAX_BLOCK);
    }
}
