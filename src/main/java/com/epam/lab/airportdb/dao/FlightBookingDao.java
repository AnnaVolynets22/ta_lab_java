package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.FlightBooking;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FlightBookingDao implements Dao<FlightBooking>{

    @Override
    public Optional<FlightBooking> get(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<FlightBooking> getAll() {
        return null;
    }

    @Override
    public int create(FlightBooking flightBooking) {

        return 0;
    }

    @Override
    public int update(FlightBooking flightBooking) throws SQLException {
        return 0;
    }

    @Override
    public int delete(FlightBooking flightBooking) {

        return 0;
    }
}
