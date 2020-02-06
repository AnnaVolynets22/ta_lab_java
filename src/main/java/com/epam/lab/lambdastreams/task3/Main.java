package com.epam.lab.lambdastreams.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static List<Integer> generateRandomList(int lowRange, int upperRange, int limit) {
        IntStream stream = new Random().ints(limit, lowRange, upperRange);
        return stream.boxed().collect(Collectors.toList());
    }

    public static List<Integer> generateRandomList(int limit) {
        return Stream.generate(new Random()::nextInt)
                .limit(5)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        List<Integer> list1 = generateRandomList(0, 20, 5);
        List<Integer> list2 = generateRandomList(10);
        logger.info("List1");
        list1.forEach(logger::info);
        //logger.info("List2");
        //list2.forEach(logger::info);
        OptionalDouble average = list1
                .stream()
                .mapToInt(a -> a)
                .average();
        logger.info("List1 average: " + average);

        OptionalInt max = list1
                .stream()
                .mapToInt(a->a)
                .max();
        logger.info("List1 max: " + max);

        int sum = list1
                .stream()
                .mapToInt(a -> a)
                .sum();
        logger.info("List1 sum: " + sum);

        int reduce = list1
                .stream()
                .reduce(0, Integer::sum);
        logger.info("List1 reduce result: " + reduce);

        long biggerThanAverage = list1
                .stream()
                .filter(n->n > average.getAsDouble())
                .count();
        logger.info("List1 number of values that are bigger than average: " + biggerThanAverage);
    }
}
