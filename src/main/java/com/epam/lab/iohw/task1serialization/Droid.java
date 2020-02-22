package com.epam.lab.iohw.task1serialization;

import java.io.Serializable;

public class Droid implements Serializable {
    private String name;

    public Droid(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name:" + getName() +
                '}';
    }
}
