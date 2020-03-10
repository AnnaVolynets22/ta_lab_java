package com.epam.lab.airportdb.service;

import com.epam.lab.airportdb.dao.FlightBookingDao;
import com.epam.lab.airportdb.model.FlightBooking;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FlightBookingService implements Service<FlightBooking> {
    private static final Logger log = LogManager.getLogger(FlightBookingService.class);

    private FlightBookingDao flightBookingDao = new FlightBookingDao();
    private FlightService flightService = new FlightService();
    private PassagerService passagerService = new PassagerService();

    @Override
    public Optional<FlightBooking> find(String id) throws SQLException {
        return flightBookingDao.get(id);
    }

    @Override
    public List<FlightBooking> findAll() throws SQLException {
        return flightBookingDao.getAll();
    }

    @Override
    public int create(FlightBooking flightBooking) throws SQLException {
        createSubEntitiesIfNotExist(flightBooking);
        return flightBookingDao.create(flightBooking);
    }

    @Override
    public int update(FlightBooking flightBooking) throws SQLException {
        createSubEntitiesIfNotExist(flightBooking);
        return flightBookingDao.update(flightBooking);
    }

    @Override
    public int delete(FlightBooking flightBooking) throws SQLException {
        return flightBookingDao.delete(flightBooking);
    }

    public Optional<FlightBooking> findByflightNumber(String flightNumber) throws SQLException {
        return flightBookingDao.getByFlightNumber(flightNumber);
    }

    public void printMainBookingInfo(String id) throws SQLException {
        String info = flightBookingDao.getMainBookingInfo(id);
        if (info == null) {
            log.info("Nothing was found!");
        } else {
            log.info(info);
        }
    }

    public void findAndPrintBookingInfo(String id) throws SQLException {
        Optional<FlightBooking> flightBooking = flightBookingDao.get(id);
        if (flightBooking != null) {
            log.info(flightBooking.get().toString());
        } else {
            log.info("Booking with  " + id + " not found");
        }
    }

    public void printAllBookings() throws SQLException {
        List<FlightBooking> flightBookings = flightBookingDao.getAll();
        flightBookings.forEach(log::info);
    }

    private void createSubEntitiesIfNotExist(FlightBooking flightBooking) throws SQLException {
        if (flightService.find(flightBooking.getFlight().getFlightNumber().toString()).get() == null) {
            flightService.create(flightBooking.getFlight());
        }
        if (passagerService.find(flightBooking.getPassager().getId().toString()).get() == null) {
            passagerService.create(flightBooking.getPassager());
        }
    }
}
