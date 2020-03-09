package com.epam.lab.airportdb.constants;

public final class SqlQueryConst {
    private static final String PLANE_FIND_ALL_PLANES = "SELECT * FROM Plane";
    private static final String DELETE_PLANE = "DELETE FROM Plane WHERE id=?";
    private static final String CREATE_PLANE = "INSERT Plane (planeNumber, capacity) VALUES (?, ?)";
    private static final String UPDATE_PLANE = "UPDATE Plane SET planeNumber=?, capacity=? WHERE id=?";
    private static final String FIND_PLANE_BY_ID = "SELECT * FROM Plane WHERE id=?";

    private static final String PLANE_FIND_ALL_AIRLINES = "SELECT * FROM Airline";
    private static final String DELETE_AIRLINE = "DELETE FROM Airline WHERE id=?";
    private static final String CREATE_AIRLINE = "INSERT Airline (airlineName, capacity) VALUES (?, ?)";
    private static final String UPDATE_AIRLINE = "UPDATE Plane SET planeNumber=?, capacity=? WHERE id=?";
    private static final String FIND_AIRLINE_BY_ID = "SELECT * FROM Plane WHERE id=?";
    private SqlQueryConst(){
        throw  new IllegalStateException("Utility class");
    }
}
