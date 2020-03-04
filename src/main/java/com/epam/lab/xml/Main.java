package com.epam.lab.xml;

import com.epam.lab.xml.models.Beer;
import com.epam.lab.xml.parsers.BeerDOMParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Parsing xml file:");
        BeerDOMParser domParser = null;
        try {
            domParser = new BeerDOMParser(PropertiesUtils.getProperty("xmlFile"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Beer> beers = domParser.parseXML();
        beers.forEach(logger::info);

    }
}
