package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.connection.ConnectionHandler;
import com.epam.lab.airportdb.model.Flight;
import com.epam.lab.airportdb.model.FlightBooking;
import com.epam.lab.airportdb.model.Passager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.lab.airportdb.constants.SqlQueryConst.*;

public class FlightBookingDao implements Dao<FlightBooking>{

    private FlightDao flightDao = new FlightDao();
    private PassagerDao passagerDao = new PassagerDao();

    @Override
    public Optional<FlightBooking> get(String id) throws SQLException {
        FlightBooking flightBooking = null;
        Connection conn = ConnectionHandler.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(FIND_FRIGHT_BOOKING_BY_ID)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Flight flight = flightDao.get(rs.getString("flightNumber")).get();
                    Passager passager = passagerDao.get(rs.getString("passagerId")).get();
                    flightBooking = new FlightBooking( rs.getInt("bookingId"), flight, passager, rs.getString("seat"));
                }
            }
        }
        return Optional.of(flightBooking);
    }

    @Override
    public List<FlightBooking> getAll() throws SQLException {
        List<FlightBooking> flightBookings = new ArrayList<>();
        Connection conn = ConnectionHandler.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(FIND_ALL_FLIGHt_BOOKINGS)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Flight flight = flightDao.get(rs.getString("flightNumber")).get();
                    Passager passager = passagerDao.get(rs.getString("passagerId")).get();
                    flightBookings.add(new FlightBooking( rs.getInt("bookingId"), flight, passager, rs.getString("seat")));
                }
            }
        }
        return flightBookings;
    }

    @Override
    public int create(FlightBooking flightBooking) throws SQLException {

        return prepareAndExecuteStatement(flightBooking, CREATE_FLIGHT_BOOKING);
    }

    @Override
    public int update(FlightBooking flightBooking) throws SQLException {
        return prepareAndExecuteStatement(flightBooking, UPDATE_FLIGHT_BOOKING);
    }

    @Override
    public int delete(FlightBooking flightBooking) throws SQLException {
        Connection conn = ConnectionHandler.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE_FLIGHT_BOOKING)){
            ps.setString(1, flightBooking.getBookingId().toString());
            return ps.executeUpdate();
        }
    }

    private int prepareAndExecuteStatement(FlightBooking flightBooking, String query) throws SQLException {
        Connection conn = ConnectionHandler.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, flightBooking.getFlight().getFlightNumber());
            ps.setInt(2, flightBooking.getPassager().getId());
            ps.setString(3, flightBooking.getSeat());
              return ps.executeUpdate();
        }
    }
}
