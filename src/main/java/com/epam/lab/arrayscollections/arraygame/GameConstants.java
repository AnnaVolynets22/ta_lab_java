package com.epam.lab.arrayscollections.arraygame;

public final class GameConstants {
    private GameConstants(){
        throw  new IllegalStateException("Utility class");
    }

    public static final int INITIAL_POWER = 25;
    public static final int ARTEFACT_LOWER_POWER = 10;
    public static final int ARTEFACT_HIGHER_POWER = 80;
    public static final int MONSTER_LOWER_POWER = 5;
    public static final int MONSTER_HIGHER_POWER = 100;
}
