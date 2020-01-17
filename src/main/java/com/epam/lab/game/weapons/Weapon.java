package com.epam.lab.game.weapons;

import java.util.Random;

public abstract class Weapon implements WeaponBehavior {
    int maxAttacks;
    String name;

    @Override
    public int useWeapon() {
        Random rnd = new Random();
        return rnd.nextInt(maxAttacks)+1;
    }

    @Override
    public String getName() {
        return name;
    }
}
