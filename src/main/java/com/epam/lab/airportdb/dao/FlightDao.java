package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.connection.ConnectionHandler;
import com.epam.lab.airportdb.model.Airline;
import com.epam.lab.airportdb.model.City;
import com.epam.lab.airportdb.model.Flight;
import com.epam.lab.airportdb.model.Plane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.lab.airportdb.constants.SqlQueryConst.*;

public class FlightDao implements Dao<Flight> {

    private CityDao cityDao = new CityDao();
    private PlaneDao planeDao = new PlaneDao();
    private AirlineDao airlineDao = new AirlineDao();

    @Override
    public Optional<Flight> get(String id) throws SQLException {
        Flight flight = null;
        Connection conn = ConnectionHandler.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(FIND_FRIGHT_BY_ID)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    City  departureCity = cityDao.get(rs.getString("departureCity")).get();
                    City  destinationCity = cityDao.get(rs.getString("destinationCity")).get();
                    Plane plane = planeDao.get(rs.getString("planeId")) .get();
                    Airline airline = airlineDao.get(rs.getString("airlineId")) .get();
                    flight = new Flight( rs.getInt("flightNumber"), airline, plane, departureCity, destinationCity,
                            rs.getTimestamp("departureTime"), rs.getTimestamp("arrivalTime"));
                }
            }
        }
        return Optional.of(flight);
    }

    @Override
    public List<Flight> getAll() throws SQLException {
        List<Flight> flights = new ArrayList<>();
        Connection conn = ConnectionHandler.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(FIND_ALL_FLIGHTS)) {
              try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    City  departureCity = cityDao.get(rs.getString("departureCity")).get();
                    City  destinationCity = cityDao.get(rs.getString("destinationCity")).get();
                    Plane plane = planeDao.get(rs.getString("planeId")) .get();
                    Airline airline = airlineDao.get(rs.getString("airlineId")) .get();
                    flights.add(new Flight( rs.getInt("flightNumber"), airline, plane, departureCity, destinationCity,
                            rs.getTimestamp("departureTime"), rs.getTimestamp("arrivalTime")));
                }
            }
        }
        return flights;
    }

    @Override
    public int create(Flight flight) throws SQLException {

        return prepareAndExecuteStatement(flight, CREATE_FLIGHT);
    }

    @Override
    public int update(Flight flight) throws SQLException {

        return prepareAndExecuteStatement(flight, UPDATE_FLIGHT);
    }

    @Override
    public int delete(Flight flight) throws SQLException {
        Connection conn = ConnectionHandler.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE_FLIGHT)){
            ps.setString(1, flight.getFlightNumber().toString());
            return ps.executeUpdate();
        }
    }

    private int prepareAndExecuteStatement(Flight flight, String query) throws SQLException {
        Connection conn = ConnectionHandler.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            if (cityDao.get(flight.getDepartureCity().getId().toString()).get() == null){
                cityDao.create(flight.getDepartureCity());
            }
            if (cityDao.get(flight.getDestinationCity().getId().toString()).get() == null){
                cityDao.create(flight.getDestinationCity());
            }
            ps.setInt(1, flight.getAirline().getId());
            ps.setInt(2, flight.getPlane().getId());
            ps.setInt(3, flight.getDepartureCity().getId());
            ps.setInt(4, flight.getDestinationCity().getId());
            ps.setTimestamp(5, flight.getDepartureTime());
            ps.setTimestamp(6, flight.getArrivalTime());
            return ps.executeUpdate();
        }
    }
}
