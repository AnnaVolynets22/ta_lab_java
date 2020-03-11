package com.epam.lab.airportdb.menu;

import com.epam.lab.airportdb.model.Airline;
import com.epam.lab.airportdb.model.Country;
import com.epam.lab.airportdb.model.Passager;
import com.epam.lab.airportdb.model.Plane;
import com.epam.lab.airportdb.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private static final Logger log = LogManager.getLogger(View.class);

    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public View() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("A", "   A - Select all data");

        menu.put("1", "   1 - Table: Plane");
        menu.put("11", "  11 - Create for Plane");
        menu.put("12", "  12 - Update Plane");
        menu.put("13", "  13 - Delete from Plane");
        menu.put("14", "  14 - Select Plane");
        menu.put("15", "  15 - Find Plane by ID");

        menu.put("2", "   2 - Table: Airline");
        menu.put("21", "  21 - Create for Airline");
        menu.put("22", "  22 - Update Airline");
        menu.put("23", "  23 - Delete from Airline");
        menu.put("24", "  24 - Select Airline");
        menu.put("25", "  25 - Find Airline by ID");

        menu.put("3", "   3 - Table: Flight");
        menu.put("31", "  31 - Create for Flight");
        menu.put("32", "  32 - Update Flight");
        menu.put("33", "  33 - Delete from Flight");
        menu.put("34", "  34 - Select Flight");
        menu.put("35", "  35 - Find Flight by ID");

        menu.put("4", "   4 - Table: FlightBooking");
        menu.put("41", "  41 - Create for FlightBooking");
        menu.put("42", "  42 - Update FlightBooking");
        menu.put("43", "  43 - Delete from FlightBooking");
        menu.put("44", "  44 - Select FlightBooking");
        menu.put("45", "  45 - Find FlightBooking by ID");
        menu.put("46", "  46 - Print main booking info by ID");

        menu.put("5", "   5 - Table: Passager");
        menu.put("51", "  51 - Create for Passager");
        menu.put("52", "  52 - Update Passager");
        menu.put("53", "  53 - Delete from Passager");
        menu.put("54", "  54 - Select Passager");
        menu.put("55", "  55 - Find Passager by ID");

        menu.put("Q", "   Q - exit");

        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createForPlane);
        methodsMenu.put("12", this::updatePlane);
        methodsMenu.put("13", this::deleteFromPlane);
        methodsMenu.put("14", this::selectPlane);
        methodsMenu.put("15", this::findPlaneByID);

        methodsMenu.put("21", this::createForAirline);
        methodsMenu.put("22", this::updateAirline);
        methodsMenu.put("23", this::deleteFromAirline);
        methodsMenu.put("24", this::selectAirline);
        methodsMenu.put("25", this::findAirlineByID);

        methodsMenu.put("31", this::createFlight);
        methodsMenu.put("32", this::updateFlight);
        methodsMenu.put("33", this::deleteFromFlight);
        methodsMenu.put("34", this::selectFlight);
        methodsMenu.put("35", this::findFlightByID);

        methodsMenu.put("41", this::createForFlightBooking);
        methodsMenu.put("42", this::updateFlightBooking);
        methodsMenu.put("43", this::deleteFlightBooking);
        methodsMenu.put("44", this::selectFlightBooking);
        methodsMenu.put("45", this::findFlightBookingByID);
        methodsMenu.put("46", this::printMainBookingInfo);

        methodsMenu.put("51", this::createForPassager);
        methodsMenu.put("52", this::updatePassager);
        methodsMenu.put("53", this::deletePassager);
        methodsMenu.put("54", this::selectPassager);
        methodsMenu.put("55", this::findPassagerByID);
    }

    private void selectAllTable() throws SQLException {
        selectPlane();
        selectAirline();
        selectFlight();
        selectFlightBooking();
        selectPassager();
    }

    private void findAirlineByID() throws SQLException {
        log.info("Input ID of Airline you are looking for: ");
        String id = input.nextLine();
        AirlineService service = new AirlineService();
        service.findAirlineAndPrintInfo(id);
    }

    private void selectAirline() throws SQLException {
        log.info("Table: Airline");
        AirlineService service = new AirlineService();
        service.printAllAirlines();
    }

    private void deleteFromAirline() throws SQLException {
        log.info("\nInput Airline ID: ");
        String id = input.nextLine();
        AirlineService service = new AirlineService();
        int count = service.delete(id);
        log.info(count + "rows were deleted\n");
    }

    private void updateAirline() throws SQLException {
        log.info("Input Airline ID : ");
        String id = input.next();
        log.info("Input airlineName: ");
        String airlineName = input.next();
        AirlineService service = new AirlineService();
        Airline entity = service.find(id).get();
        entity.setAirlineName(airlineName);
        int count = service.update(entity);
        log.info(count + "rows were updated\n");
    }

    private void createForAirline() throws SQLException {
        log.info("Input Airline ID : ");
        int id = input.nextInt();
        log.info("Input airlineName: ");
        String airlineName = input.next();
        log.info("Input address: ");
        String address = input.next();
        AirlineService service = new AirlineService();
        AddressService addressService = new AddressService();
        Airline entity = new Airline(id, airlineName, addressService.find(address).get());
        int count = service.create(entity);
        log.info(count + "rows were updated\n");
    }

    private void findPlaneByID() throws SQLException {
        log.info("Input ID of Plane you are looking for: ");
        String id = input.nextLine();
        PlaneService planeService = new PlaneService();
        planeService.printPlane(id);
    }

    private void selectPlane() throws SQLException {
        log.info("Table: Plane");
        PlaneService planeService = new PlaneService();
        planeService.printAllPlanes();
    }

    private void deleteFromPlane() throws SQLException {
        log.info("\nInput Plane ID: ");
        String id = input.nextLine();
        PlaneService planeService = new PlaneService();
        int count = planeService.delete(id);
        log.info(count + "rows were deleted\n");
    }

    private void findPassagerByID() throws SQLException {
        log.info("Input ID of Passager you are looking for: ");
        String id = input.nextLine();
        PassagerService service = new PassagerService();
        service.find(id);
    }

    private void selectPassager() throws SQLException {
        log.info("Table: Passager");
        PassagerService service = new PassagerService();
        service.printAllPassagers();
    }

    private void deletePassager() throws SQLException {
        log.info("\nInput Passager ID: ");
        String id = input.nextLine();
        PassagerService service = new PassagerService();
        int count = service.delete(id);
        log.info(count + "rows were deleted\n");
    }

    private void updatePassager() throws SQLException {
        log.info("Input Passager ID : ");
        String id = input.next();
        log.info("Input FirstName: ");
        String firstName = input.next();
        log.info("Input SecondName: ");
        String secondName = input.next();
        log.info("Input nationality: ");
        String nationality = input.next();
        log.info("Input age: ");
        int age = input.nextInt();
        PassagerService service = new PassagerService();
        Passager entity = service.find(id).get();
        entity.setFirstName(firstName);
        entity.setSecondName(secondName);
        entity.setNationality(nationality);
        entity.setAge(age);
        int count = service.update(entity);
        log.info(count + "rows were updated\n");
    }

    private void createForPassager() {
        throw new UnsupportedOperationException("Method is not implemented yet in menu.");
    }

    private void printMainBookingInfo() throws SQLException {
        log.info("Input ID of FlightBooking you are looking for: ");
        String id = input.nextLine();
        FlightBookingService service = new FlightBookingService();
        service.printMainBookingInfo(id);
    }

    private void findFlightBookingByID() throws SQLException {
        log.info("Input ID of FlightBooking you are looking for: ");
        String id = input.nextLine();
        FlightBookingService service = new FlightBookingService();
        service.findAndPrintBookingInfo(id);
    }
    private void selectFlightBooking() throws SQLException {
        log.info("Table: FlightBooking");
        FlightBookingService service = new FlightBookingService();
        service.printAllBookings();
    }

    private void deleteFlightBooking() throws SQLException {
        log.info("\nInput FlightBooking number: ");
        String id = input.nextLine();
        FlightBookingService service = new FlightBookingService();
        int count = service.delete(id);
        log.info(count + "rows were deleted\n");
    }

    private void updateFlightBooking() {
        throw new UnsupportedOperationException("Method is not implemented yet in menu.");
    }

    private void createForFlightBooking() {
        throw new UnsupportedOperationException("Method is not implemented yet in menu.");
    }

    private void findFlightByID() throws SQLException {
        log.info("Input ID of Flight you are looking for: ");
        String id = input.nextLine();
        FlightService service = new FlightService();
        service.findFligtAndPrintInfo(id);
    }

    private void selectFlight() throws SQLException {
        log.info("Table: Flight");
        FlightService service = new FlightService();
        service.printAllFligh();
    }

    private void deleteFromFlight() throws SQLException {
        log.info("\nInput Flight number: ");
        String id = input.nextLine();
        FlightService service = new FlightService();
        int count = service.delete(id);
        log.info(count + "rows were deleted\n");
    }

    private void updateFlight() {
        throw new UnsupportedOperationException("Method is not implemented yet in menu.");
    }

    private void createFlight() {
        throw new UnsupportedOperationException("Method is not implemented yet in menu.");
    }

    private void createContactDetails(){

    }

    private void createAddress(){

    }

    private void createCity(){

    }

    private void createCountry(){
        log.info("Input Country name : ");
        String countryName = input.next();
        log.info("Input 1 - if country in in EU and 0 otherwise: ");
        int isEu = input.nextInt();
        boolean isEuB = false;
        if(isEu==1)isEuB = true;
        Country country = new Country(countryName, isEuB);
    }


    private void updatePlane() throws SQLException {
        log.info("Input Plane ID : ");
        String id = input.next();
        log.info("Input planeNumber for Plane: ");
        String planeNumber = input.next();
        log.info("Input capacity for Plane: ");
        int capacity = input.nextInt();
        PlaneService planeService = new PlaneService();
        Plane entity = planeService.find(id).get();

        entity.setPlaneNumber(planeNumber);
        entity.setCapacity(capacity);
        int count = planeService.update(entity);
        log.info(count + "rows were updated\n");
    }

    private void createForPlane() throws SQLException {
        log.info("Input Plane ID : ");
        int id = input.nextInt();
        log.info("Input planeNumber for Plane: ");
        String planeNumber = input.next();
        log.info("Input capacity for Plane: ");
        int capacity = input.nextInt();
        PlaneService planeService = new PlaneService();
        Plane entity = new Plane(id, planeNumber, capacity);
        int count = planeService.create(entity);
        log.info(count + "rows were updated\n");
    }


    private void outputMenu() {
        log.info("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) log.info(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        log.info("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) log.info(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            log.info("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                log.info("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            }
            catch (UnsupportedOperationException e) {
                log.info(e.getMessage());
            }catch (Exception e) {
                log.info(e.getMessage());
            }
        } while (!keyMenu.equals("Q"));
    }
}
