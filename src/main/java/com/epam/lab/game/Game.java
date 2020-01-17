package com.epam.lab.game;

import java.util.Scanner;

public class Game {

    private Scanner scanner;

    public void start() {
        System.out.println("Please choose your character: 1- , 2 - ");
        scanner = new Scanner(System.in);
        //scanner.nextInt();
        Warrior warrior1 = new Warrior("Warrior1", 1000, 120, 40);
        Warrior warrior2 = new Warrior("Warrior2", 1000, 120, 40);
        Battle.startFight(warrior1, warrior2);
    }

}
