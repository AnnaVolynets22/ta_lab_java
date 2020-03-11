package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.connection.ConnectionHandler;
import com.epam.lab.airportdb.model.Flight;
import com.epam.lab.airportdb.model.FlightBooking;
import com.epam.lab.airportdb.model.Passager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.lab.airportdb.constants.SqlQueryConst.*;

public class FlightBookingDao implements Dao<FlightBooking> {

    private FlightDao flightDao = new FlightDao();
    private PassagerDao passagerDao = new PassagerDao();

    @Override
    public Optional<FlightBooking> get(String id) throws SQLException {
        return getByField(id, FIND_FLIGHT_BOOKING_BY_ID);
    }

    public Optional<FlightBooking> getByFlightNumber(String flightNumber) throws SQLException {
        return getByField(flightNumber, FIND_FLIGHT_BOOKING_BY_FLIGHT_NUMBER);
    }

    public Optional<FlightBooking> getByField(String fieldValue, String query) throws SQLException {
        FlightBooking flightBooking = null;
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(query)) {
            ps.setString(1, fieldValue);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Flight flight = flightDao.get(rs.getString("flightNumber")).get();
                    Passager passager = passagerDao.get(rs.getString("passagerId")).get();
                    flightBooking = new FlightBooking(rs.getInt("bookingId"), flight, passager, rs.getString("seat"));
                }
            }
        }
        return Optional.of(flightBooking);
    }

    @Override
    public List<FlightBooking> getAll() throws SQLException {
        List<FlightBooking> flightBookings = new ArrayList<>();
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_ALL_FLIGHt_BOOKINGS)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Flight flight = flightDao.get(rs.getString("flightNumber")).get();
                    Passager passager = passagerDao.get(rs.getString("passagerId")).get();
                    flightBookings.add(new FlightBooking(rs.getInt("bookingId"), flight, passager, rs.getString("seat")));
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
    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(DELETE_FLIGHT_BOOKING)) {
            ps.setString(1, id);
            return ps.executeUpdate();
        }
    }

    public String getMainBookingInfo(String id) throws SQLException {
        String bookingInfo = null;
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_SELECTET_INFO_BY_JOIN)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    bookingInfo = String.format("Flight number: %d Seat: %s FirstName: %s SecondName: %s phone: %s city: %s",
                            rs.getInt("flightNumber"), rs.getString("seat"), rs.getString("firstName"),
                            rs.getString("secontName"), rs.getString("phone"), rs.getString("cityName"));
                }
            }
        }
        return bookingInfo;
    }

    private int prepareAndExecuteStatement(FlightBooking flightBooking, String query) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(query)) {
            ps.setInt(1, flightBooking.getFlight().getFlightNumber());
            ps.setInt(2, flightBooking.getPassager().getId());
            ps.setString(3, flightBooking.getSeat());
            return ps.executeUpdate();
        }
    }
}
