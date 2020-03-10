package com.epam.lab.airportdb;

import com.epam.lab.airportdb.service.AddressService;
import com.epam.lab.airportdb.service.CityService;
import com.epam.lab.airportdb.service.CountryService;
import com.epam.lab.airportdb.service.PlaneService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Application {
    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        CountryService countryService = new CountryService();
        CityService cityService = new CityService();
        AddressService addressService = new AddressService();
        PlaneService planeService = new PlaneService();
        try {
           // countryService.printAllCountries();
            //countryService.findCountryAndPrintInfo("Italy");
            //cityService.printAllCities();
            //addressService.printAllAddresses();
            planeService.printAllPlanes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
