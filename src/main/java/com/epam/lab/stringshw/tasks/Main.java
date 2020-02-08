package com.epam.lab.stringshw.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        //Using the documentation for java.util.regex.Pattern as a resource, write and test a regular expression that
        // checks a sentence to see that it begins with a capital letter and ends with a period.
        String pattern = "^[A-Z]+[\\w\\d\\s]*[.]$";
        List<String> testData = List.of("Same sentence.", "not sentence", "Sentence without period");
        Pattern p = Pattern.compile(pattern);

        testData.forEach(s -> {
            Matcher m = p.matcher(s);
            if (m.matches()) logger.info(String.format("Sentence which matches: %s", s));
        });

        //Split some string on the words "the" or "you".
        String test = "My test string with you and the and other.";
        test = test.replace(" you", " the");
        String[] words = test.split(" the");
        Arrays.stream(words).forEach(logger::info);

        //Replace all the vowels in some text with underscores.
        //A, E, I, O, U, Y
        String[] vowels = {"a", "e", "i", "o", "u", "y"};
        logger.info(String.format("String before replacement: %s", test));
        for(String v: vowels){
           test = test.replace(v, "_");
        }
        logger.info(String.format("String after replacement: %s", test));
    }
}
