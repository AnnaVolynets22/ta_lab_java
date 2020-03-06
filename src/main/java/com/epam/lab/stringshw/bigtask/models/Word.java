package com.epam.lab.stringshw.bigtask.models;

import java.util.ArrayList;
import java.util.List;

public class Word {
    List<Character> characterList = new ArrayList<>();
    public Word(String s) {
        for (char ch: s.toCharArray()) {
            characterList.add(ch);
        }
    }
}
