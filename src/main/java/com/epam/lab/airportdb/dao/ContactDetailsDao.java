package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.model.ContactDetails;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ContactDetailsDao implements Dao<ContactDetails> {

    @Override
    public Optional<ContactDetails> get(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<ContactDetails> getAll() {
        return null;
    }

    @Override
    public int create(ContactDetails contactDetails) {

        return 0;
    }

    @Override
    public int update(ContactDetails contactDetails) throws SQLException {
        return 0;
    }


    @Override
    public int delete(ContactDetails contactDetails) {

        return 0;
    }
}
