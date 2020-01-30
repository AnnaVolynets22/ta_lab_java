package com.epam.lab.arrayscollections1.stringcontainer4;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger1 = LogManager.getLogger(Main.class);

    public static void main(String[] args){

        long startTime = System.nanoTime();
        MyStringContainer myStringContainer = new MyStringContainer();

        myStringContainer.add("A");
        myStringContainer.add("B");
        myStringContainer.add("A");
        myStringContainer.add("C");
        myStringContainer.add("A");
        myStringContainer.add("D");

        myStringContainer.get(3);

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        logger1.info("Execution time for custom container in nanoseconds: " + timeElapsed);

        startTime = System.nanoTime();
        List<String> arrayList = new ArrayList<>();

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("A");
        arrayList.add("C");
        arrayList.add("A");
        arrayList.add("D");

        arrayList.get(3);

        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        logger1.info("Execution time for ArrayList in nanoseconds " + timeElapsed);

    }

}
