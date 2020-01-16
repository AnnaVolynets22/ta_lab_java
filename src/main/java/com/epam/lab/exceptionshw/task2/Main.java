package com.epam.lab.exceptionshw.task2;

import com.epam.lab.exceptionshw.task2.enums.Color;
import com.epam.lab.exceptionshw.task2.enums.Type;
import com.epam.lab.exceptionshw.task2.exception_classes.ColorException;
import com.epam.lab.exceptionshw.task2.exception_classes.TypeException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        ArrayList<Plant> plants = new ArrayList<>();
        plants.add(new Plant(15, Color.GREEN, Type.BAMBOO));
        plants.add(new Plant(150, Color.RED, Type.CACTUS));
        plants.add(new Plant(10, Color.BLUE, Type.TREE));
        plants.add(new Plant(5, Color.WHITE, Type.ROSA));
        plants.add(new Plant(74, Color.BLACK, Type.CACTUS));
        System.out.println("List of plants:");

        plants.forEach(plant -> System.out.println(plant));

        try{
            for(Plant plant:plants){
                System.out.println("Current plant in try block:"+ plant);
                if(plant.getColor() == Color.WHITE){
                    throw new ColorException("White color is not allowed.");
                } else if(plant.getType() == Type.TREE){
                    throw new TypeException("Tree is not allowed.");
                }
            }
        }catch (ColorException | TypeException e) {
            System.out.println("Catch exception: " + e.getMessage());
        }
    }
}
