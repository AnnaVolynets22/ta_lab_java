package com.epam.lab.game;

import com.epam.lab.game.enums.WarriorType;
import com.epam.lab.game.enums.WeaponType;
import com.epam.lab.game.warriors.*;
import com.epam.lab.game.weapons.*;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class BattleGame {

    private Scanner scanner;

    public void start() {
        System.out.println("Following warriors are available: Roman, Spartan, Samurai, Ninja, Kozak");
        System.out.println("Please enter name of your warrior character for the battle:");
        scanner = new Scanner(System.in);
        String warriorType = scanner.next();
        //Random selection of enemy type
        String randomWarriorType = WarriorType.getRandomWarrior().toString();

        Warrior warrior1 = createWarrior(warriorType);
        Warrior warrior2 = createWarrior(randomWarriorType);

        //Change name of enemy warrior in case both warriors are of the same type
        if(warriorType.equals(randomWarriorType)){
            warrior2.setName(warrior2.getName() + "_Enemy");
        }

        System.out.println("Following weapons are available: Axe, Bow, Dagger, Sword");
        System.out.println("Please enter type of weapon:");

        warrior1.setWeapon(chooseWeapon(scanner.next()));
        //Random selection of enemy weapon type
        warrior2.setWeapon(chooseWeapon(WeaponType.getRandomWeapon().toString()));

        startBattle(warrior1, warrior2);

    }

    private Warrior createWarrior(String warriorType){
        switch(warriorType){
            case("Roman"):
                return new Roman();
            case("Spartan"):
                return new Spartan();
            case("Samurai"):
                return new Samurai();
            case("Ninja"):
                return new Ninja();
            case("Kozak"):
                return new Kozak();
            default:
                throw new InvalidParameterException("Cannon find warrior of entered type.");
        }
    }

    private  WeaponBehavior chooseWeapon(String weaponType){
        switch(weaponType){
            case("Axe"):
                return new Axe();
            case("Bow"):
                return new Bow();
            case("Dagger"):
                return new Dagger();
            case("Sword"):
                return new Sword();
            default:
                throw new InvalidParameterException("Cannon find weapon of entered type.");
        }
    }

    private  void startBattle(Warrior warrior1, Warrior warrior2){

        System.out.println("Lets start a battle:");
        System.out.println("First warrior " + warrior1.getName() + " uses " + warrior1.getWeaponName());
        System.out.println("Second warrior " + warrior2.getName() + " uses " + warrior2.getWeaponName());

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

    private String getAttackResult(Warrior warriorA, Warrior warriorB){
        // Calculate one warrior attack and the others block
        int warriorAAtt = warriorA.fight();
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
