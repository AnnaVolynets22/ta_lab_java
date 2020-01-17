package com.epam.lab.game.weapons;

import com.epam.lab.game.constants.Constants;

public class Bow extends Weapon{

    public Bow(){
        maxAttacks = Constants.BOW_WEAPON_MAX_ATTACKS;
        name = "Bow";
    }
}
