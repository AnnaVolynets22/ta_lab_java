package com.epam.lab.game.warriors;

import com.epam.lab.game.weapons.WeaponBehavior;

import java.util.Random;

public abstract class Warrior {

    private String name;
    private int health;
    private int blockMax;
    private WeaponBehavior weapon;
    private Random rnd = new Random();

    public Warrior( String name, int health, int blockMax) {
        this.name = name;
        this.health = health;
        this.blockMax = blockMax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
         this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health){this.health = health;}

    public void setWeapon(WeaponBehavior weapon){
        this.weapon = weapon;
    }

    public String getWeaponName() {
        return weapon.getName();
    }

    public int fight(){
       return weapon.useWeapon();
    }

    public int block(){
        return rnd.nextInt(blockMax) + 1;
    }
}
