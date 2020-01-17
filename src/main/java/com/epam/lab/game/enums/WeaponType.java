package com.epam.lab.game.enums;

import java.util.Random;

public enum WeaponType {
    Axe,
    Bow,
    Dagger,
    Sword;

    public static WeaponType getRandomWeapon(){
        Random rnd = new Random();
        return values()[rnd.nextInt(values().length)];
    }
}
