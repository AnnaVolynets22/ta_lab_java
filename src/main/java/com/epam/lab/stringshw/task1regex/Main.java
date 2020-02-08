package com.epam.lab.stringshw.task1regex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        String pattern = "^[A-Z]+[\\w\\d\\s]*[.]$";
        String sentence = "Same sentence.";
        List<String> testData = List.of("Same sentence.", "not sentence", "Sentence without period");
        Pattern p = Pattern.compile(pattern);

        testData.forEach(s ->{Matcher m = p.matcher(s);
        if(m.matches()) logger.info(String.format("Sentence which matches: %s", s));
        });

    }
}
