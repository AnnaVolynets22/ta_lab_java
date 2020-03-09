package com.epam.lab.airportdb;

import com.epam.lab.airportdb.service.CountryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Application {
    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        CountryService countryService = new CountryService();
        try {
            countryService.printAllCountries();
            countryService.findCountryAndPrintInfo("Italy");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
