package com.epam.lab.xml_json.parsers;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.epam.lab.xml_json.models.Beer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BeerGsonParser {

    private Gson gson;

    public BeerGsonParser() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.setPrettyPrinting().create();
    }

    public List<Beer> getListOfBeers(String jsonFilePath) {
        Path jsonFileP = Paths.get(jsonFilePath);
        Beer[] beers = new Beer[0];
        try {
            beers = gson.fromJson(new FileReader(jsonFileP.toFile()), Beer[].class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Arrays.asList(beers);
    }

}
