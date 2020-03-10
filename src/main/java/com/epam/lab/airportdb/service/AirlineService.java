package com.epam.lab.airportdb.service;

import com.epam.lab.airportdb.dao.AirlineDao;
import com.epam.lab.airportdb.model.Airline;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AirlineService implements Service<Airline> {
    private static final Logger log = LogManager.getLogger(AirlineService.class);
    AirlineDao airlineDao = new AirlineDao();

    @Override
    public Optional<Airline> find(String id) throws SQLException {
        return airlineDao.get(id);
    }

    @Override
    public List<Airline> findAll() throws SQLException {
        return airlineDao.getAll();
    }

    @Override
    public int create(Airline airline) throws SQLException {
        return airlineDao.create(airline);
    }

    @Override
    public int update(Airline airline) throws SQLException {
        return airlineDao.update(airline);
    }

    @Override
    public int delete(Airline airline) throws SQLException {
        return airlineDao.delete(airline);
    }

    public void findAirlineAndPrintInfo(String id) throws SQLException {
        Optional<Airline> airline = airlineDao.get(id);
        if (airline != null) {
            log.info(airline.get().toString());
        } else {
            log.info("Airline with  " + id + " not found");
        }
    }

    public void printAllCities() throws SQLException {
        List<Airline> airlines = airlineDao.getAll();
        airlines.forEach(log::info);
    }
}
