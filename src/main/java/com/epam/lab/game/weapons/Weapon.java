package com.epam.lab.game.weapons;

import java.util.Random;

public abstract class Weapon implements WeaponBehavior {
    int maxAttacks ;
    String name;
    private Random rnd = new Random();

    @Override
    public int useWeapon() {
        return rnd.nextInt(maxAttacks)+1;
    }

    @Override
    public String getName() {
        return name;
    }
}
