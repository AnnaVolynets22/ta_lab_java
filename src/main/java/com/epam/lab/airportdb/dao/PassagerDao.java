package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.Passager;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PassagerDao  implements Dao<Passager>{

    @Override
    public Optional<Passager> get(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Passager> getAll() {
        return null;
    }

    @Override
    public int create(Passager passager) {

        return 0;
    }

    @Override
    public int update(Passager passager) {

        return 0;
    }

    @Override
    public int delete(Passager passager) {

        return 0;
    }
}
