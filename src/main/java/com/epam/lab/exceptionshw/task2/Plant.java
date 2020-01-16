package com.epam.lab.exceptionshw.task2;

import com.epam.lab.exceptionshw.task2.enums.Color;
import com.epam.lab.exceptionshw.task2.enums.Type;
import com.epam.lab.exceptionshw.task2.exception_classes.ColorException;
import com.epam.lab.exceptionshw.task2.exception_classes.TypeException;

public class Plant {
    private int size;
    private Color color;
    private Type type;

    public Plant(int size, Color color, Type type) {
        this.size = size;
        this.color = color;
        this.type = type;
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
