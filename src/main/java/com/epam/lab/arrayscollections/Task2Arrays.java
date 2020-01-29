package com.epam.lab.arrayscollections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Task2Arrays {
    private static Logger logger1 = LogManager.getLogger(Task2Arrays.class);

    public static int[] findCommon(int[] array1, int[] array2, int length) {
        int[] array3 = new int[length];
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

    public static int[] removeElements(int[] array, int [] remove) {
        int targetIndex = 0;
        print(remove);
        for (int sourceIndex = 0; sourceIndex < array.length; sourceIndex++) {
            for(int j=0; j <remove.length; j++) {
                if (array[sourceIndex] != remove[j])
                    array[targetIndex++] = array[sourceIndex];
                logger1.info(targetIndex++);
            }
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

    public static int[] removeElemRepeatMoreThan2Times(int[] arr){
        int[] newArr = new int [arr.length];
        Arrays.sort(arr);
        int j = 0;
        if(arr[0] != arr[1]){
            newArr[j] = arr[0];
            j++;
        }

        if((arr[1] != arr[0]) && arr[1] !=arr[2]){
            arr[j] = arr[1];
            j++;
        }

        for(int i=2; i<arr.length-1; i++){
            if ((arr[i-1] != arr[i+1]) && (arr[i] != arr[i-2])) {
                newArr[j] = arr[i];
                j++;
            }
            if((arr[arr.length-3]!= arr[arr.length-1])){
                newArr[j] = arr[arr.length-1];
            }
        }
        return removeZeros(newArr);
    }

    public static int[] removeSameElementsLocatedOneAfterAnother(int[] arr){
        int[] newArr = new int [arr.length];
        newArr[0] = arr[0];
        int j = 1;
        for(int i =1; i<=arr.length-1; i++){
            if (arr[i-1] != arr[i]) {
                newArr[j] = arr[i];
                j++;
            }
        }
        return removeZeros(newArr);
    }

    public static void print(int[] array){
        logger1.info(java.util.Arrays.toString(array));
    }


    public static void main(String[] args) {
        logger1.info("A...Дано два масиви. Сформувати третій масив, що складається з тих елементів, які: ");
        logger1.info("а) присутні в обох масивах;");
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10, 11};
        int[] array2 = {6, 0, 7, 8, 9, 10, 7, 11, 12, 13, 14};
        logger1.info("Array 1:");
        print(array1);
        logger1.info("Array 2:");
        print(array2);
        int length = array1.length <= array2.length ? array1.length: array2.length;
        logger1.info("Common elements:");
        int [] common;
        if(length == array1.length) {
            common = findCommon(array1, array2, length);
        }else {
            common = findCommon(array2, array1, length);
        }
        print(common);

        logger1.info("A...Дано два масиви. Сформувати третій масив, що складається з тих елементів, які: ");
        logger1.info("б) присутні тільки в одному з масивів.");
        logger1.info("Array 1:");
        print(array1);
        logger1.info("Array 2:");
        print(array2);
        logger1.info("Array all:");
        print(joinArrays(array1, array2));
        print(removeElements(joinArrays(array1, array2), common));

        logger1.info("B. Видалити в масиві всі числа, які повторюються більше двох разів.");
        logger1.info("Вхідний масив:");
        int [] array3 = {1, 2, 2, 10, 2, 5, 6, 7, 7, 9, 10};
        print(array3);
        logger1.info("Вихідний масив:");
        print(removeElemRepeatMoreThan2Times(array3));



        logger1.info("C. Знайти в масиві всі серії однакових елементів, які йдуть підряд, " +
                "і видалити з них всі елементи крім одного.");
        int [] array4 = {1, 2, 2, 10, 2, 5, 6, 7, 7, 7, 7, 9, 10};
        logger1.info("Вхідний масив:");
        print(array4);
        logger1.info("Вихідний масив:");
        print(removeSameElementsLocatedOneAfterAnother(array4));

    }
}
