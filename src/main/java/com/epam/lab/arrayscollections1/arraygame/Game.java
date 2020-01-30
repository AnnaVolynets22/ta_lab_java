package com.epam.lab.arrayscollections1.arraygame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private static Logger logger1 = LogManager.getLogger(Game.class);
    /*D. Герой комп'ютерної гри, що володіє силою в 25 балів, знаходиться в круглому залі, з якого ведуть 10 закритих дверей.
    За кожними дверима героя чекає або магічний артефакт, що дарує силу від 10 до 80 балів, або монстр, який має силу від 5 до 100 балів,
     з яким герою потрібно битися. Битву виграє персонаж, що володіє найбільшою силою; якщо сили рівні, перемагає герой.
1. Організувати введення інформації про те, що знаходиться за дверима, або заповнити її, використовуючи генератор випадкових чисел.
2. Вивести цю саму інформацію на екран в зрозумілому табличному вигляді.
3. Порахувати, за скількома дверима героя чекає смерть. Рекурсивно.
4. Вивести номери дверей в тому порядку, в якому слід їх відкривати герою, щоб залишитися в живих, якщо таке можливо.*/
    private int playerPower = GameConstants.INITIAL_POWER;
    private int[] doors = new int[10];


    public int getPower(){
        int r = ThreadLocalRandom.current().nextInt(2);
        if(r == 0){
            return ThreadLocalRandom.current().nextInt(GameConstants.ARTEFACT_LOWER_POWER,
                    GameConstants.ARTEFACT_HIGHER_POWER+ 1);
        } else{
            return -1*ThreadLocalRandom.current().nextInt(GameConstants.MONSTER_LOWER_POWER,
                    GameConstants.MONSTER_HIGHER_POWER+ 1);
        }
    }

    public void generatePower(){
        for(int i=0; i<doors.length; i++ ){
            doors[i] = getPower();
        }
    }

    public void print(){
        for(int i=0; i<doors.length; i++){
            int j= i+1;
            if(doors[i] < 0){
                logger1.info("Dor:" + j + " Monster with power:" + (-1)*doors[i]);
            } else {
                logger1.info("Dor:" + j + " Artefact with power:" + doors[i]);
            }

        }
    }

    public int countDeathDor(int currentIndex) {
        if (currentIndex == doors.length) return 0;
        else {
            if ((doors[currentIndex] < 0) && (doors[currentIndex] * (-1) > 25)) {
                return 1 + countDeathDor(currentIndex + 1);
            } else {
                return countDeathDor(currentIndex + 1);
            }
        }
    }

    public void findDorCombination(){
        int monsterPower = 0;
        StringBuilder monsterDoors = new StringBuilder();
        StringBuilder artifactsDoors = new StringBuilder();
        for(int i=0; i<doors.length; i++){
            if(doors[i]<0){
                monsterPower += -1*doors[i];
                monsterDoors.append(" ");
                monsterDoors.append(i+1);
            } else {
                playerPower += doors[i];
                artifactsDoors.append( " ");
                artifactsDoors.append(i+1);
            }
        }

        if(monsterPower > playerPower){
            logger1.info("You won't win:(");
        } else {
            logger1.info(" To win you need to open doors in the following sequence:");
            logger1.info(artifactsDoors.append(monsterDoors));
        }
    }

    public void start(){
        this.generatePower();
        this.print();
        int deathCount = this.countDeathDor(0);
        logger1.info("Death awaits behind " + deathCount + " doors!");
        this.findDorCombination();
    }

}
