package com.epam.lab.airportdb.service;

import com.epam.lab.airportdb.dao.CountryDao;
import com.epam.lab.airportdb.model.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CountryService implements Service<Country> {
    private static final Logger log = LogManager.getLogger(CountryService.class);

    private CountryDao countryDao = new CountryDao();

    @Override
    public Optional<Country> find(String id) throws SQLException {
        return countryDao.get(id);
    }

    @Override
    public List<Country> findAll() throws SQLException {
        return countryDao.getAll();
    }

    @Override
    public int create(Country country) throws SQLException {
        return countryDao.create(country);
    }

    @Override
    public int update(Country country) throws SQLException {
        return countryDao.update(country);
    }

    @Override
    public int delete(String id) throws SQLException {
        return countryDao.delete(id);
    }

    public void findCountryAndPrintInfo(String countryName) throws SQLException {
        Optional<Country> country = countryDao.get(countryName);
        if (country != null) {
            log.info(country.get().toString());
        } else {
            log.info("Country " + countryName + " not found");
        }
    }

    public void printAllCountries() throws SQLException {
        List<Country> countries = countryDao.getAll();
        countries.forEach(log::info);
    }
}
