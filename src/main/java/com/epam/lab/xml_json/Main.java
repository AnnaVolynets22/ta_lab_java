package com.epam.lab.xml_json;

import com.epam.lab.xml_json.models.Beer;
import com.epam.lab.xml_json.parsers.BeerDOMParser;
import com.epam.lab.xml_json.parsers.BeerGsonParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        logger.info("Parsing xml file:");
        BeerDOMParser domParser = null;
        try {
            domParser = new BeerDOMParser(PropertiesUtils.getProperty("xmlFile"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Beer> beersFromXml = domParser.parseXML();
        beersFromXml.forEach(logger::info);

        logger.info("Parsing json file:");
        BeerGsonParser beerGsonParser = new BeerGsonParser();
        List<Beer> beersFromJson = beerGsonParser.getListOfBeers(PropertiesUtils.getProperty("jsonFile"));
        beersFromJson.forEach(logger::info);
    }
}
