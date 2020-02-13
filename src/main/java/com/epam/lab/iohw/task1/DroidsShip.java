package com.epam.lab.iohw.task1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DroidsShip<T extends Droid> implements Serializable {
    private List<T> ship = new ArrayList<>();

    public void put(T droid) {
        ship.add(droid);
    }

    public List<? extends Droid> getDroids() {
        return ship;
    }

    public void addAll(List<? extends T> droids) {
        ship.addAll(droids);
    }
}
