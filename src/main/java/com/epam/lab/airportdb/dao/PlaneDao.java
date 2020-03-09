package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.Plane;

import java.util.List;
import java.util.Optional;

public class PlaneDao implements Dao<Plane> {
    @Override
    public Optional<Plane> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Plane> getAll() {
        return null;
    }

    @Override
    public void save(Plane plane) {

    }

    @Override
    public void update(Plane plane, String[] params) {

    }

    @Override
    public void delete(Plane plane) {

    }
}
