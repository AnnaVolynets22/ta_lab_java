package com.epam.lab.arrayscollections1.sortstrings5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    private static Logger logger1 = LogManager.getLogger(Main.class);

    public static void main(String[] args){
        ArrayList<MyString> arrayList = new ArrayList<>();
        MyString[] myArr = new MyString[3];
        MyString italy = new MyString("Italy", "Roma");
        MyString ukraine = new MyString("Ukraine", "Kyiv");
        MyString austria = new MyString("Austria", "Vienna");

        myArr[0] = italy;
        myArr[1] = ukraine;
        myArr[2] = austria;
        
        logger1.info(("Array:"));
        for( MyString s:myArr) {
            logger1.info(s.print());
        }
        
        Arrays.sort(myArr);
        
        logger1.info(("Sorted array by first string"));
        for( MyString s:myArr) {
            logger1.info(s.print());
        }
        arrayList.add(italy);
        arrayList.add( ukraine);
        arrayList.add(austria);
        
        logger1.info(("ArrayList"));
        arrayList.forEach(i-> logger1.info(i.print()));
        Collections.sort(arrayList);
        logger1.info(("Sorted arrayList by first string"));
        arrayList.forEach(i-> logger1.info(i.print()));

        logger1.info(("Sorted arrayList by second string"));
        MyStringComparator myStringComparator = new MyStringComparator();
        arrayList.sort(myStringComparator);
        arrayList.forEach(i-> logger1.info(i.print()));
    }
}
