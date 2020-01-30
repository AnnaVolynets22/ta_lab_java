package com.epam.lab.arrayscollections.arraygame;

public final class GameConstants {
    private GameConstants(){
        throw  new IllegalStateException("Utility class");
    }

    public static int INITIAL_POWER = 25;
    public static int ARTEFACT_LOWER_POWER = 10;
    public static int ARTEFACT_HIGHER_POWER = 80;
    public static int MONSTER_LOWER_POWER = 5;
    public static int MONSTER_HIGHER_POWER = 100;
}
