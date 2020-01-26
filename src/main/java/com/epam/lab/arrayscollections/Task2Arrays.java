package com.epam.lab.arrayscollections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Task2Arrays {
    private static Logger logger1 = LogManager.getLogger(Task2Arrays.class);

    public static List<Integer>  findCommon(Integer[] array1, Integer[] array2){
        List<Integer> commonElemets = new ArrayList<>();
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if(array1[i] == array2[j]){
                    if(!commonElemets.contains(array1[i])) {
                        commonElemets.add(array1[i]);
                    }
                }
            }
        }
        return commonElemets;
    }

    public static List<Integer> findUnique(Integer[] array1, Integer[] array2){
        List<Integer> uniqueElements = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(array1));
        set.addAll(Arrays.asList(array2));
        set.removeAll(findCommon(array1, array2));
        uniqueElements.addAll(set);
        return uniqueElements;
    }

    public static List<Integer> deleteCommon(Integer[] array){
        List<Integer> list = new LinkedList<>(Arrays.asList(array));

        return list;
    }
    public static void main(String[] args) {
        //A...Дано два масиви. Сформувати третій масив, що складається з тих елементів, які: а) присутні в обох масивах;
        // б) присутні тільки в одному з масивів.
        Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] array2 = {6, 7, 8, 9, 10, 11, 12, 13, 14};
        List<Integer> commonElemets = new ArrayList<>();
        commonElemets = findCommon(array1, array2);
        logger1.info("Common elements:");
        commonElemets.forEach(logger1::info);
        List<Integer> uniqueElements = findUnique(array1, array2);
        logger1.info("Unique elements:");
        uniqueElements.forEach(logger1::info);

        // B. Видалити в масиві всі числа, які повторюються більше двох разів.

        //C. Знайти в масиві всі серії однакових елементів, які йдуть підряд, і видалити з них всі елементи крім одного.
        Integer[] array3 = {1, 2, 2, 2, 5, 6, 7, 7, 9, 10};
        logger1.info("Delete common :");
        deleteCommon(array3).forEach(logger1::info);

    }
}
