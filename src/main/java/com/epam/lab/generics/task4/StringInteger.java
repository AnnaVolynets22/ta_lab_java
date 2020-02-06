package com.epam.lab.generics.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class StringInteger {
    private static Logger logger1 = LogManager.getLogger(StringInteger.class);
    public static void addToList(List list) {
        list.add("A");
        list.add("123");
    }

    public static void main(String[] args) {
        List<Integer> myIntegerList = new ArrayList<>();
        addToList(myIntegerList);
        logger1.info(myIntegerList.get(0));;
    }
}
