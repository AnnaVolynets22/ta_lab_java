package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.Flight;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Flight> {

    @Override
    public Optional<Flight> get(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Flight> getAll() {
        return null;
    }

    @Override
    public int create(Flight flight) {

        return 0;
    }

    @Override
    public int update(Flight flight) {

        return 0;
    }

    @Override
    public int delete(Flight flight) {

        return 0;
    }
}
