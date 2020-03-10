package com.epam.lab.airportdb.service;

import com.epam.lab.airportdb.dao.ContactDetailsDao;
import com.epam.lab.airportdb.model.ContactDetails;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ContactDetailsService implements Service<ContactDetails> {
    ContactDetailsDao contactDetailsDao = new ContactDetailsDao();
    @Override
    public Optional<ContactDetails> find(String id) throws SQLException {
        return contactDetailsDao.get(id);
    }

    @Override
    public List<ContactDetails> findAll() throws SQLException {
        return contactDetailsDao.getAll();
    }

    @Override
    public int create(ContactDetails contactDetails) throws SQLException {
        return contactDetailsDao.create(contactDetails);
    }

    @Override
    public int update(ContactDetails contactDetails) throws SQLException {
        return contactDetailsDao.update(contactDetails);
    }

    @Override
    public int delete(ContactDetails contactDetails) throws SQLException {
        return contactDetailsDao.delete(contactDetails);
    }
}
