package com.epam.lab.game.constants;

public final class Constants {

   private Constants(){
     throw  new IllegalStateException("Utility class");
   }

   //Constants for weapons
   public static final int AXE_WEAPON_MAX_ATTACKS = 55;
   public static final int BOW_WEAPON_MAX_ATTACKS = 60;
   public static final int DAGGER_WEAPON_MAX_ATTACKS = 50;
   public static final int SWORD_WEAPON_MAX_ATTACKS = 70;

   //Constants for warriors
   public static final int SAMURAI_HEALTH = 1000;
   public static final int SAMURAI_MAX_BLOCK = 120;
   public static final int NINJA_HEALTH = 900;
   public static final int NINJA_MAX_BLOCK = 110;
   public static final int SPARTAN_HEALTH = 1100;
   public static final int SPARTAN_MAX_BLOCK = 130;
   public static final int ROMAN_HEALTH = 1200;
   public static final int ROMAN_MAX_BLOCK = 140;
   public static final int KOZAK_HEALTH = 1500;
   public static final int KOZAK_MAX_BLOCK = 150;

   public static final String GAME_OVER_STR = "Game over";
   public static final String FIGHT_AGAIN_STR = "Fight again";

}
