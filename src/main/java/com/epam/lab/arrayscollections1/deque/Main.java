package com.epam.lab.arrayscollections1.deque;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger1 = LogManager.getLogger(Main.class);
    public static void main(String[] args){
        MyDeque myDeque = new MyDeque();
        myDeque.add(1);
        myDeque.add(3);
        myDeque.add(4);
        myDeque.add(5);
        myDeque.add(4);
        myDeque.addLast(17);
        myDeque.addFirst(100);
        logger1.info(myDeque);
        logger1.info("remove first " );
        myDeque.removeFirst();
        logger1.info(myDeque);
        logger1.info("remove last " );
        myDeque.removeLast();
        logger1.info(myDeque);
        logger1.info("remove first occurrence of " + 4);
        myDeque.removeFirstOccurrence(4);
        logger1.info(myDeque);
    }
}
