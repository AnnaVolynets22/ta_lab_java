package com.epam.lab.airportdb.service;

import com.epam.lab.airportdb.dao.CityDao;
import com.epam.lab.airportdb.model.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CityService implements Service<City> {
    private static final Logger log = LogManager.getLogger(CityService.class);

    CityDao cityDao = new CityDao();

    @Override
    public Optional<City> find(String id) throws SQLException {
        return cityDao.get(id);
    }

    @Override
    public List<City> findAll() throws SQLException {
        return cityDao.getAll();
    }

    @Override
    public int create(City city) throws SQLException {
        return cityDao.create(city);
    }

    @Override
    public int update(City city) throws SQLException {
        return cityDao.update(city);
    }

    @Override
    public int delete(City city) throws SQLException {
        return cityDao.delete(city);
    }

    public void findCityAndPrintInfo(String id) throws SQLException {
        Optional<City> city = cityDao.get(id);
        if (city != null) {
            log.info(city.get().toString());
        } else {
            log.info("City with  " + id + " not found");
        }
    }

    public void printAllCities() throws SQLException {
        List<City> cities = cityDao.getAll();
        cities.forEach(log::info);
    }
}
