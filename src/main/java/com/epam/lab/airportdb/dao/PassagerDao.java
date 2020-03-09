package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.Passager;

import java.util.List;
import java.util.Optional;

public class PassagerDao  implements Dao<Passager>{
    @Override
    public Optional<Passager> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Passager> getAll() {
        return null;
    }

    @Override
    public void save(Passager passager) {

    }

    @Override
    public void update(Passager passager, String[] params) {

    }

    @Override
    public void delete(Passager passager) {

    }
}
