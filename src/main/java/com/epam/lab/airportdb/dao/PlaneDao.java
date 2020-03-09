package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.Plane;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PlaneDao implements Dao<Plane> {

    @Override
    public Optional<Plane> get(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Plane> getAll() {
        return null;
    }

    @Override
    public int create(Plane plane) {

        return 0;
    }

    @Override
    public int update(Plane plane) {

        return 0;
    }

    @Override
    public int delete(Plane plane) {

        return 0;
    }
}
