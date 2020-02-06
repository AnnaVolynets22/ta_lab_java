package com.epam.lab.arrayscollections1.sortstrings5;

public class MyString implements Comparable{

    private String string1;
    private String string2;

    public MyString(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    public String getString1() {
        return string1;
    }

    public String getString2() {
        return string2;
    }

    @Override
    public int compareTo(Object o) {
        return this.string1.compareTo(o.toString());
    }

    @Override
    public String toString(){
        return this.string1;
    }

    public String print(){
        return string1 + " " + string2;
    }
}
