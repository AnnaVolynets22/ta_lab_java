package com.epam.lab.lambdastreams.task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static List<String> ReadLineOfCharsFromConsoleWithInputStream(){
        logger.info("Please enter text:");
        InputStream is = null;
        BufferedReader br = null;
        List<String> list = new ArrayList<>();
        try {
            is = System.in;
            br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while (!(line = br.readLine()).trim().equals("")) {
                list.add(line);
            }
        }
        catch (IOException ioe) {
            logger.info("Exception while reading input " + ioe);
        }
        finally {
            // close the streams using close method
            try {
                if (br != null) {
                    br.close();
                }
            }
            catch (IOException ioe) {
                logger.info("Error while closing stream: " + ioe);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = ReadLineOfCharsFromConsoleWithInputStream();
        List<String> wordsList = list
                .stream()
                .flatMap(e -> Stream.of(e.split(" ")))
                .collect(Collectors.toList());

        List<String> uniqueWords = wordsList
                .stream()
                .distinct()
                .collect(Collectors.toList());

        List<String> sortedUniqueWords = uniqueWords
                .stream()
                .sorted()
                .collect(Collectors.toList());

        logger.info("Unique words number:" + uniqueWords.size());
        logger.info("Unique words:");
        logger.info(sortedUniqueWords);
        Map<String, Integer> collectWordsCount = wordsList
                .stream()
                .collect(groupingBy(Function.identity(), summingInt(e -> 1)));

        logger.info("Words count:");
        collectWordsCount.forEach((k, v) -> logger.info(k + "-" + v + " "));

        List<String> symbolsList = wordsList
                .stream()
                .flatMap(e -> Stream.of(e.split("")))
                .collect(Collectors.toList());

        Map<String, Integer> collectSymbolsCount = symbolsList
                .stream()
                .collect(groupingBy(Function.identity(), summingInt(e -> 1)));

        logger.info("Symbols count:");
        collectSymbolsCount.forEach((k, v) -> logger.info(k + "-" + v + " "));
    }

}
