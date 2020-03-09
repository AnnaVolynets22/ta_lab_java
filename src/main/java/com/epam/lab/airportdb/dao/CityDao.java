package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.City;

import java.util.List;
import java.util.Optional;

public class CityDao implements Dao<City> {
    @Override
    public Optional<City> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<City> getAll() {
        return null;
    }

    @Override
    public void save(City city) {

    }

    @Override
    public void update(City city, String[] params) {

    }

    @Override
    public void delete(City city) {

    }
}
