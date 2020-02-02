package com.epam.lab.generics.task2shipwithdroids;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Logger logger1 = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        DroidsShip<Droid> droidShip = new DroidsShip<>();
        droidShip.put(new Droid("Droid"));
        droidShip.put(new DroidClass1("DroidClass1"));

        List<Droid> list= new ArrayList<>();
        list.add(new DroidClass2("DroidClass2"));
        list.add(new Droid("Droid"));

        droidShip.addAll(list);
        droidShip.getDroids().forEach(droid->logger1.info(droid.getName()));
    }
}
