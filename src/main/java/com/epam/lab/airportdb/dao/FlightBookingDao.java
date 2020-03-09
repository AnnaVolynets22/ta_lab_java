package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.FlightBooking;

import java.util.List;
import java.util.Optional;

public class FlightBookingDao implements Dao<FlightBooking>{
    @Override
    public Optional<FlightBooking> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<FlightBooking> getAll() {
        return null;
    }

    @Override
    public void save(FlightBooking flightBooking) {

    }

    @Override
    public void update(FlightBooking flightBooking, String[] params) {

    }

    @Override
    public void delete(FlightBooking flightBooking) {

    }
}
