package com.epam.lab.arrayscollections1.sortstrings5;

import java.util.Comparator;

public class MyStringComparator implements Comparator<MyString> {
    @Override
    public int compare(MyString myString, MyString t1) {
        return myString.getString2().compareTo(t1.getString2());
    }
}
