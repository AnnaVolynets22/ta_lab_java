package com.epam.lab.collections2.treemap;

import com.epam.lab.arrayscollections.Task2Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger1 = LogManager.getLogger(Main.class);
    public static void main(String[] args){
        MyTreeMap<Integer, Integer> treeMap = new MyTreeMap<>();
         logger1.info(treeMap.toString());
    }
}
