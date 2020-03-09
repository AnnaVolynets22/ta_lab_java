package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.City;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CityDao implements Dao<City> {

    @Override
    public Optional<City> get(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<City> getAll() {
        return null;
    }

    @Override
    public int create(City city) {

        return 0;
    }

    @Override
    public int update(City city) throws SQLException {
        return 0;
    }

    @Override
    public int delete(City city) {

        return 0;
    }
}
