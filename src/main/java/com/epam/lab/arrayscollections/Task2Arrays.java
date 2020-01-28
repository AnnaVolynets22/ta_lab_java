package com.epam.lab.arrayscollections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Task2Arrays {
    private static Logger logger1 = LogManager.getLogger(Task2Arrays.class);

    public static int[] findCommon(int[] array1, int[] array2) {
        int[] array3 = array1.length <= array2.length ? new int[array1.length] : new int[array2.length];
        boolean zeroFlag = false;
        if (array1.length <= array2.length) {
            for (int i = 0; i < array1.length; i++) {
                for (int j = 0; j < array2.length; j++) {
                    if (array1[i] == (array2[j])) {
                        array3[i] = array1[i];
                        if(array1[i] == 0){
                            zeroFlag = true;
                        }

                    }
                }
            }
        } else {
            for (int i = 0; i < array2.length; i++) {
                for (int j = 0; j < array1.length; j++) {
                    if (array2[i] == (array1[j])) {
                        array3[i] = array2[i];
                        if(array1[i] == 0){
                            zeroFlag = true;
                        }
                    }
                }
            }
        }
        return findUnique(array3, zeroFlag);
    }

    public static int[] findUnique(int[] array, boolean zeroFlag) {
        int[] arrayUnique = new int[array.length];
        Boolean isEquval = false;
        arrayUnique[0] = array[0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < arrayUnique.length; j++) {
                if (array[i] == arrayUnique[j]) {
                    isEquval = true;
                    break;
                }
            }
            if (!isEquval) {
                arrayUnique[i] = array[i];
            } else {
                isEquval = false;
            }
        }
        if(zeroFlag){
            return removeZeros1(arrayUnique);
        }else{
            return removeZeros(arrayUnique);
        }

    }

    public static int[] removeZeros(int[] array) {
        int targetIndex = 0;
        for (int sourceIndex = 0; sourceIndex < array.length; sourceIndex++) {
            if (array[sourceIndex] != 0)
                array[targetIndex++] = array[sourceIndex];
        }
        int[] newArray = new int[targetIndex];
        System.arraycopy(array, 0, newArray, 0, targetIndex);
        return newArray;
    }

    public static int[] removeZeros1(int[] array) {
        int targetIndex = 0;
        for (int sourceIndex = 0; sourceIndex < array.length; sourceIndex++) {
            if (array[sourceIndex] != 0)
                array[targetIndex++] = array[sourceIndex];
        }
        int[] newArray = new int[targetIndex+1];
        System.arraycopy(array, 0, newArray, 0, targetIndex+1);
        return newArray;
    }

    public static int[] joinArrays(int[] array1, int[] array2){
        int[] arrAll = new int [array1.length+array2.length];
        System.arraycopy(array1, 0, arrAll, 0, array1.length);
        System.arraycopy(array2, 0, arrAll, array1.length, array2.length);
        return arrAll;
    }

    public static void print(int[] array){
        logger1.info(java.util.Arrays.toString(array));
    }


    public static void main(String[] args) {
        //A...Дано два масиви. Сформувати третій масив, що складається з тих елементів, які: а) присутні в обох масивах;
        // б) присутні тільки в одному з масивів.
        int[] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10, 11};
        int[] array2 = {6, 0, 7, 8, 9, 10, 7, 11, 11, 12, 13, 14};
        logger1.info("Array 1:");
        print(array1);
        logger1.info("Array 2:");
        print(array2);
        //logger1.info("Common elements:");
        //print(findCommon(array1, array2));

        logger1.info("Array all:");
        print(joinArrays(array1, array2));

        // B. Видалити в масиві всі числа, які повторюються більше двох разів.
        // Integer[] array3 = {1, 2, 2, 2, 5, 6, 7, 7, 9, 10};
        //logger1.info("Delete elements which repeat more than two times :");
        // removeElementsThatRepeatMoreThan2Times(array3).forEach(logger1::info);

        //C. Знайти в масиві всі серії однакових елементів, які йдуть підряд, і видалити з них всі елементи крім одного.

        //logger1.info("Delete common :");


    }
}
