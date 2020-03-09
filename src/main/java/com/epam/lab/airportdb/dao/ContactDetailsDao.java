package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.ContactDetails;

import java.util.List;
import java.util.Optional;

public class ContactDetailsDao implements Dao<ContactDetails> {
    @Override
    public Optional<ContactDetails> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<ContactDetails> getAll() {
        return null;
    }

    @Override
    public void save(ContactDetails contactDetails) {

    }

    @Override
    public void update(ContactDetails contactDetails, String[] params) {

    }

    @Override
    public void delete(ContactDetails contactDetails) {

    }
}
