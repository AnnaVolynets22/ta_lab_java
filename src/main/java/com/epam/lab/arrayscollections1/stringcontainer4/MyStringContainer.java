package com.epam.lab.arrayscollections1.stringcontainer4;

import java.util.Arrays;

public class MyStringContainer {
    private String[] stringArr = new String[5];
    int index = 0;

    public String get(int i){
        return stringArr[i];
    }

    public void add(String item){
        if(index != stringArr.length){
            stringArr[index] = item;
        } else{
            stringArr = Arrays.copyOf(stringArr, stringArr.length + 5);
            stringArr[index] = item;
        }
        index++;
    }

    @Override
    public String toString() {
        String arrItems = "[";
        for(String s: stringArr){
            if(s != null){
                arrItems += " " + s;
            }
        }
        return arrItems + " ]";
    }
}
