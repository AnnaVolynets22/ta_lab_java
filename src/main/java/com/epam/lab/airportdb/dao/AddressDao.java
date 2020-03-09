package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.Address;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AddressDao implements Dao<Address> {

    @Override
    public Optional<Address> get(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public int create(Address address) {

        return 0;
    }

    @Override
    public int update(Address address) throws SQLException {
        return 0;
    }


    @Override
    public int delete(Address address) {

        return 0;
    }
}
