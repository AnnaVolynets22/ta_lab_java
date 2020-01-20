package com.epam.lab.exceptionshw.task2;

import com.epam.lab.exceptionshw.task2.enums.Color;
import com.epam.lab.exceptionshw.task2.enums.Type;
import com.epam.lab.exceptionshw.task2.exception_classes.ColorException;
import com.epam.lab.exceptionshw.task2.exception_classes.TypeException;

import java.util.ArrayList;
import java.util.List;

public class Plant {
    private int size;
    private Color color;
    private Type type;

    static List<Color> allowedColors = new ArrayList<>(List.of(Color.BLUE, Color.GREEN, Color.WHITE));
    static List<Type> availableTypes = new ArrayList<>(List.of(Type.CACTUS, Type.BAMBOO, Type.ROSA));

    public Plant(int size, Color color, Type type) throws ColorException, TypeException {
        this.size = size;

        if(allowedColors.contains(color)){
            this.color = color;
        }else{
            throw new ColorException(color + " color is not allowed.");
        }

        if(availableTypes.contains(type)){
            this.type = type;
        }else{
            throw new TypeException(type + " type is not available");
        }

    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Size: "+ size + " Color: " + color + " Type: " + type;
    }
}
