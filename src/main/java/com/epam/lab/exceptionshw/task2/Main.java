package com.epam.lab.exceptionshw.task2;

import com.epam.lab.exceptionshw.task2.enums.Color;
import com.epam.lab.exceptionshw.task2.enums.Type;
import com.epam.lab.exceptionshw.task2.exception_classes.ColorException;
import com.epam.lab.exceptionshw.task2.exception_classes.TypeException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        System.out.println("Allowed plant colors: " );
        Plant.allowedColors.forEach(System.out::println);
        System.out.println("Available plant types: ");
        Plant.availableTypes.forEach(System.out::println);
        ArrayList<Plant> plants = new ArrayList<>();
        try {
            plants.add(new Plant(15, Color.GREEN, Type.BAMBOO));
            plants.add(new Plant(150, Color.WHITE, Type.CACTUS));
            plants.add(new Plant(10, Color.BLUE, Type.TREE));
            plants.add(new Plant(5, Color.RED, Type.ROSA));
            plants.add(new Plant(74, Color.BLACK, Type.CACTUS));

            System.out.println("List of plants:");
            plants.forEach(System.out::println);

        }catch (ColorException | TypeException e) {
            System.out.println("Catch exception: " + e.getMessage());
        }
    }
}
