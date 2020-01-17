package com.epam.lab.game;

public class Battle {
    public static void startFight(Warrior warrior1, Warrior warrior2){
        // Loop giving each warrior a chance to attack and block each turn until 1 dies
        while(true){
            if(getAttackResult(warrior1, warrior2).equals("Game Over")){
                System.out.println("Game Over");
                break;
            }

            if(getAttackResult(warrior2, warrior1).equals("Game Over")){
                System.out.println("Game Over");
                break;
            }

        }
    }

    public static String getAttackResult(Warrior warriorA, Warrior warriorB){
        // Calculate one warrior attack and the others block
        int warriorAAtt = warriorA.attack();
        int warriorBBlk = warriorB.block();

        // Subtract block from attack
        int warriorBDmg = warriorAAtt - warriorBBlk;

        // If there was damage subtract that from the health
        if(warriorBDmg > 0){
            warriorB.setHealth(warriorB.getHealth()-warriorBDmg);
        } else warriorBDmg = 0;

        System.out.println(warriorA.getName() + " attacks " + warriorB.getName() + " and deals " + warriorBDmg +
                " damage");
        System.out.println(warriorB.getName() + " has " + warriorB.getHealth() + " health");

        /* Check if the warriors health fell below zero and if so print a message and send
        a response that will end the loop*/
        if(warriorB.getHealth() <= 0){
            System.out.println(warriorB.getName() + " has died and " + warriorA.getName() + " is winner.");
            return "Game Over";
        }
        return "Fight again";
    }

}
