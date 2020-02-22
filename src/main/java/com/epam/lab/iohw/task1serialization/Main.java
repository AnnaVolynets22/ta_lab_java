package com.epam.lab.iohw.task1serialization;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        DroidsShip<Droid> droidShip = new DroidsShip<>();
        droidShip.put(new Droid("droid1"));
        droidShip.put(new DroidClass1("droidClass1", 10));
        List<Droid> list = new ArrayList<>();
        list.add(new DroidClass2("droidClass2", 30));
        list.add(new Droid("droid2"));
        droidShip.addAll(list);
        logger.info("Object before serialization contains:");
        droidShip.getDroids().forEach(droid -> logger.info(droid.toString()));

        try (FileOutputStream fos = new FileOutputStream("ship.ser")) {
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(droidShip);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Object has been serialized.");

        try (FileInputStream fis = new FileInputStream("ship.ser")) {
            try (ObjectInputStream ois = new ObjectInputStream(fis)) {
                DroidsShip deserDroidShip = (DroidsShip) ois.readObject();

                logger.info("Object has been de-serialized.");
                logger.info("Object after de-serialization with transient field power contains:");
                deserDroidShip.getDroids().forEach(logger::info);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
