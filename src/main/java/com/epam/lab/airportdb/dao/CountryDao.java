package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.Country;

import java.util.List;
import java.util.Optional;

public class CountryDao implements Dao<Country>{
    @Override
    public Optional<Country> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Country> getAll() {
        return null;
    }

    @Override
    public void save(Country country) {

    }

    @Override
    public void update(Country country, String[] params) {

    }

    @Override
    public void delete(Country country) {

    }
}
