package com.epam.lab.airportdb;

import com.epam.lab.airportdb.service.*;
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
        PassagerService passagerService = new PassagerService();
        FlightService flightService = new FlightService();
        FlightBookingService flightBookingService = new FlightBookingService();

        try {
           // countryService.printAllCountries();
            //countryService.findCountryAndPrintInfo("Italy");
            //cityService.printAllCities();
            //addressService.printAllAddresses();
           // planeService.printAllPlanes();
           // passagerService.printAllPassagers();
            flightService.printAllFligh();
            //flightService.findFligtAndPrintInfo("5");
            flightBookingService.printMainBookingInfo("7");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
