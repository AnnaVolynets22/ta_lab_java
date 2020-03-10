package com.epam.lab.airportdb.constants;

public final class SqlQueryConst {
    //Plane table queries
    public static final String FIND_ALL_PLANES = "SELECT * FROM Plane";
    public static final String DELETE_PLANE = "DELETE FROM Plane WHERE id=?";
    public static final String CREATE_PLANE = "INSERT Plane (planeNumber, capacity) VALUES (?, ?)";
    public static final String UPDATE_PLANE = "UPDATE Plane SET planeNumber=?, capacity=? WHERE id=?";
    public static final String FIND_PLANE_BY_ID = "SELECT * FROM Plane WHERE id=?";

    //Airline table queries
    public static final String FIND_ALL_AIRLINES = "SELECT * FROM Airline";
    public static final String DELETE_AIRLINE = "DELETE FROM Airline WHERE id=?";
    public static final String CREATE_AIRLINE = "INSERT Airline (airlineName, address) VALUES (?, ?)";
    public static final String UPDATE_AIRLINE = "UPDATE Airline SET airlineName=?, address=? WHERE id=?";
    public static final String FIND_AIRLINE_BY_ID = "SELECT * FROM  Airline WHERE id=?";
    
    //Country table queries
    public static final String FIND_ALL_COUNTRIES = "SELECT * FROM Country";
    public static final String DELETE_COUNTRY = "DELETE FROM Country WHERE id=?";
    public static final String CREATE_COUNTRY = "INSERT Country (country, isEu) VALUES (?, ?)";
    public static final String UPDATE_COUNTRY= "UPDATE Country SET isEu=? WHERE country=?";
    public static final String FIND_COUNTRY_BY_NAME = "SELECT * FROM  Country WHERE country=?";

    //City table queries
    public static final String FIND_ALL_CITIES = "SELECT * FROM City";
    public static final String DELETE_CITY = "DELETE FROM City WHERE id=?";
    public static final String CREATE_CITY = "INSERT City (cityName, cityCountry) VALUES (?, ?)";
    public static final String UPDATE_CITY = "UPDATE City SET cityName=?, cityCountry=? WHERE id=?";
    public static final String FIND_CITY_BY_ID = "SELECT * FROM  City WHERE id=?";

    //Address table queries
    public static final String FIND_ALL_ADDRESSES = "SELECT * FROM Address";
    public static final String DELETE_ADDRESS = "DELETE FROM Address WHERE id=?";
    public static final String CREATE_ADDRESS = "INSERT Address (city, street, buildNumber, flatNumber) " +
            "VALUES (?, ?, ?, ?)";
    public static final String UPDATE_ADDRESS = "UPDATE Address SET city=?, street=?, buildNumber=?, flatNumber=?" +
            " WHERE id=?";
    public static final String FIND_ADDRESS_BY_ID = "SELECT * FROM  Address WHERE id=?";

    //ContactDetails table queries
    public static final String FIND_ALL_CONTACTS = "SELECT * FROM ContactDetails";
    public static final String DELETE_CONTACT = "DELETE FROM ContactDetails WHERE id=?";
    public static final String CREATE_CONTACT = "INSERT ContactDetails (email, phone, address) VALUES (?, ?, ?)";
    public static final String UPDATE_CONTACT = "UPDATE ContactDetails SET email=?, phone=?, address=? WHERE id=?";
    public static final String FIND_CONTACT_BY_ID = "SELECT * FROM  ContactDetails WHERE id=?";

    //Passager table queries
    public static final String FIND_ALL_PASSAGERS = "SELECT * FROM Passager";
    public static final String DELETE_PASSAGER = "DELETE FROM Passager WHERE id=?";
    public static final String CREATE_PASSAGER = "INSERT Passager (secontName, firstName, nationality, age, contacts`)" +
            " VALUES (?, ?, ?, ?, ?)";
    public static final String UPDATE_PASSAGER = "UPDATE Passager SET secontName=?, firstName=?, nationality=?, age=?," +
            " contacts=? WHERE id=?";
    public static final String FIND_PASSAGER_BY_ID = "SELECT * FROM  Passager WHERE id=?";

    //Flight table queries
    public static final String FIND_ALL_FLIGHTS = "SELECT * FROM Flight";
    public static final String DELETE_FLIGHT = "DELETE FROM Flight WHERE flightNumber=?";
    public static final String CREATE_FLIGHT = "INSERT Flight (airlineId, planeId, departureCity, destinationCity, " +
            "departureTime,  arrivalTime) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_FLIGHT = "UPDATE Flight SET airlineId=?, planeId=?, departureCity=?, " +
            "destinationCity=?, departureTime=?, arrivalTime=? WHERE flightNumber=?";
    public static final String FIND_FRIGHT_BY_ID = "SELECT * FROM Flight WHERE flightNumber=?";

    //FlightBooking table queries
    public static final String FIND_ALL_FLIGHt_BOOKINGS = "SELECT * FROM FlightBooking";
    public static final String DELETE_FLIGHT_BOOKING = "DELETE FROM FlightBooking WHERE bookingId=?";
    public static final String CREATE_FLIGHT_BOOKING = "INSERT FlightBooking (flightNumper, passagerId, seat) " +
            "VALUES (?, ?, ?)";
    public static final String UPDATE_FLIGHT_BOOKING = "UPDATE FlightBooking SET flightNumber=?, passagerId=?, " +
            "seat=? WHERE bookingId=?";
    public static final String FIND_FLIGHT_BOOKING_BY_ID = "SELECT * FROM FlightBooking WHERE bookingId=?";
    public static final String FIND_FLIGHT_BOOKING_BY_FLIGHT_NUMBER = "SELECT * FROM FlightBooking WHERE flightNumber=?";

    public static final String FIND_SELECTET_INFO_BY_JOIN = "SELECT  b.flightNumber, b.seat, p.firstName, p.secontName, " +
            "c.phone, ct.cityName " +
            "FROM FlightBooking b INNER JOIN Passager p ON b.passagerId = p.id " +
            "INNER JOIN ContactDetails c ON p.contacts = c.id INNER JOIN Address a ON c.address = a.id " +
            "INNER JOIN City ct ON a.city = ct.id WHERE b.bookingId =?";
    private SqlQueryConst(){
        throw  new IllegalStateException("Utility class");
    }
}
