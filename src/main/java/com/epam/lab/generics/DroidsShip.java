package com.epam.lab.generics;

import java.util.ArrayList;
import java.util.List;

public class DroidsShip<T> {
    private List<T> ship = new ArrayList<>();

    public void put(T droid){
        ship.add(droid);
    }

    public List<T> getDroids(){
        return ship;
    }

}
