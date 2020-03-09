package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.Address;

import java.util.List;
import java.util.Optional;

public class AddressDao implements Dao<Address> {
    @Override
    public Optional<Address> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Address> getAll() {
        return null;
    }

    @Override
    public void save(Address address) {

    }

    @Override
    public void update(Address address, String[] params) {

    }

    @Override
    public void delete(Address address) {

    }
}
