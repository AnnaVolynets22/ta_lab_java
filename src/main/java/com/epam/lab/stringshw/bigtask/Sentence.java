package com.epam.lab.stringshw.bigtask;

import java.util.List;

public class Sentence {
    String s;

    public static int findSameWordsCount(String sentence) {
        String[] words = sentence.split(" ");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            count = 1;
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}
