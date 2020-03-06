package com.epam.lab.stringshw.bigtask.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sentence {
    private List<Word> words = new ArrayList<>();

    public Sentence(String s) {
        String[] words = s.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
            this.words.add(new Word(words[i]));
        }
    }

    public int findSameWordsCount() {
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            count = 1;
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {
                    count++;
                }
            }
        }
        return count;
    }


}
