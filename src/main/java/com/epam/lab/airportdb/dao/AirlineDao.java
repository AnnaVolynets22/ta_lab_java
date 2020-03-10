package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.connection.ConnectionHandler;
import com.epam.lab.airportdb.model.Address;
import com.epam.lab.airportdb.model.Airline;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.lab.airportdb.constants.SqlQueryConst.*;

public class AirlineDao implements Dao<Airline> {
    AddressDao addressDao = new AddressDao();

    @Override
    public Optional<Airline> get(String id) throws SQLException {
        Airline airline = null;
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_AIRLINE_BY_ID)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Address address = addressDao.get(rs.getString("address")).get();
                    airline = new Airline(rs.getInt("id"), rs.getString("airlineName"), address);
                }
            }
        }
        return Optional.of(airline);
    }

    @Override
    public List<Airline> getAll() throws SQLException {
        List<Airline> airlines = new ArrayList<>();
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_ALL_AIRLINES)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Address address = addressDao.get(rs.getString("id")).get();
                    airlines.add(new Airline(rs.getInt("id"), rs.getString("airlineName"), address));
                }
            }
        }
        return airlines;
    }

    @Override
    public int create(Airline airline) throws SQLException {

        return prepareAndExecuteStatement(airline, CREATE_AIRLINE);
    }

    @Override
    public int update(Airline airline) throws SQLException {
        return prepareAndExecuteStatement(airline, UPDATE_AIRLINE);
    }

    @Override
    public int delete(Airline airline) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(DELETE_CONTACT)) {
            ps.setString(1, airline.getId().toString());
            return ps.executeUpdate();
        }
    }

    private int prepareAndExecuteStatement(Airline airline, String query) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(query)) {
            if (addressDao.get(airline.getAddress().getId().toString()).get() == null) {
                addressDao.create(airline.getAddress());
            }
            ps.setString(1, airline.getAirlineName());
            ps.setInt(2, airline.getAddress().getId());
            return ps.executeUpdate();
        }
    }
}
