package com.epam.lab.collections2.treemap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger1 = LogManager.getLogger(Main.class);
    public static void main(String[] args){
        MyTreeMap<Integer, Integer> treeMap = new MyTreeMap<>();
        treeMap.put(2,3);
        treeMap.put(7,8);
         logger1.info(treeMap.toString());
        //logger1.info("Sorting is not implemented yet");
    }
}
