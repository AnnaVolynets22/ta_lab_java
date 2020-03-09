package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.Flight;

import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Flight> {
    @Override
    public Optional<Flight> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Flight> getAll() {
        return null;
    }

    @Override
    public void save(Flight flight) {

    }

    @Override
    public void update(Flight flight, String[] params) {

    }

    @Override
    public void delete(Flight flight) {

    }
}
