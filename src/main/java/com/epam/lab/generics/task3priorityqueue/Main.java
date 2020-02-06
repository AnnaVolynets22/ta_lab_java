package com.epam.lab.generics.task3priorityqueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.PriorityQueue;

public class Main {
    private static Logger logger1 = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        MyPriorityQueue<Student> myPriorityQueue = new MyPriorityQueue<>();
        logger1.info("Queue1 without comparator, sort by name:");
        myPriorityQueue.add(new Student("Anna", 30));
        myPriorityQueue.add(new Student("Ivan", 50));
        myPriorityQueue.add(new Student("Roman", 33));
        myPriorityQueue.add(new Student("Bohdan", 18));
        myPriorityQueue.forEach(logger1::info);

        logger1.info("Queue2 with comparator, desc order by mark.");
        MyPriorityQueue<Student> myPriorityQueue2 = new MyPriorityQueue<>(5, new StudentComparator());
        myPriorityQueue2.add(new Student("Anna", 30));
        myPriorityQueue2.add(new Student("Ivan", 50));
        myPriorityQueue2.add(new Student("Roman", 33));
        myPriorityQueue2.add(new Student("Bohdan", 58));
        myPriorityQueue2.forEach(logger1::info);



    }
}
