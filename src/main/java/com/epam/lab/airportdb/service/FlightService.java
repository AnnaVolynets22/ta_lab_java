package com.epam.lab.airportdb.service;

import com.epam.lab.airportdb.dao.FlightDao;
import com.epam.lab.airportdb.model.Flight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FlightService implements Service<Flight> {
    private static final Logger log = LogManager.getLogger(FlightService.class);

    private FlightDao flightDao = new FlightDao();

    @Override
    public Optional<Flight> find(String id) throws SQLException {
        return flightDao.get(id);
    }

    @Override
    public List<Flight> findAll() throws SQLException {
        return flightDao.getAll();
    }

    @Override
    public int create(Flight flight) throws SQLException {
        return flightDao.create(flight);
    }

    @Override
    public int update(Flight flight) throws SQLException {
        return flightDao.update(flight);
    }

    @Override
    public int delete(Flight flight) throws SQLException {
        return flightDao.delete(flight);
    }

    public void findFligtAndPrintInfo(String id) throws SQLException {
        Optional<Flight>  flight = flightDao.get(id);
        if (flight != null) {
            log.info(flight.get().toString());
        } else {
            log.info("City with  " + id + " not found");
        }
    }

    public void printAllFligh() throws SQLException {
        List<Flight> flights = flightDao.getAll();
        flights.forEach(log::info);
    }
}
