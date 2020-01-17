package com.epam.lab.game;

import java.util.Random;

public class Warrior {

    private String name;
    private int health;
    private int attkMax;
    private int blockMax;
    private Random rnd = new Random();

    public Warrior(String name, int health, int attkMax, int blockMax) {
        this.name = name;
        this.health = health;
        this.attkMax = attkMax;
        this.blockMax = blockMax;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttkMax() {
        return attkMax;
    }

    public int getBlockMax() {
        return blockMax;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int attack(){
        return rnd.nextInt(attkMax)+1;
    }

    public int block(){
        return rnd.nextInt(blockMax)+1;
    }
}
