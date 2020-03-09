package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.Airline;

import java.util.List;
import java.util.Optional;

public class AirlineDao implements Dao<Airline>{
    @Override
    public Optional<Airline> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Airline> getAll() {
        return null;
    }

    @Override
    public void save(Airline airline) {

    }

    @Override
    public void update(Airline airline, String[] params) {

    }

    @Override
    public void delete(Airline airline) {

    }
}
