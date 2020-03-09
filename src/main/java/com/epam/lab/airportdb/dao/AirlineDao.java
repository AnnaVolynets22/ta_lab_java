package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.Airline;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AirlineDao implements Dao<Airline>{

    @Override
    public Optional<Airline> get(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Airline> getAll() {
        return null;
    }

    @Override
    public int create(Airline airline) {

        return 0;
    }

    @Override
    public int update(Airline airline) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Airline airline) {

        return 0;
    }
}
