package com.epam.lab.game.enums;

import java.util.Random;

public enum WarriorType {
    Kozak,
    Ninja,
    Roman,
    Samurai,
    Spartan;

    public static WarriorType getRandomWarrior(){
        Random rnd = new Random();
        return values()[rnd.nextInt(values().length)];
    }
}
