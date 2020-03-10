package com.epam.lab.airportdb.service;

import com.epam.lab.airportdb.dao.PassagerDao;
import com.epam.lab.airportdb.model.Passager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PassagerService implements Service<Passager> {
    private static final Logger log = LogManager.getLogger(PassagerService.class);
    private PassagerDao passagerDao =  new PassagerDao();

    @Override
    public Optional<Passager> find(String id) throws SQLException {
        return passagerDao.get(id);
    }

    @Override
    public List<Passager> findAll() throws SQLException {
        return passagerDao.getAll();
    }

    @Override
    public int create(Passager passager) throws SQLException {
        return passagerDao.create(passager);
    }

    @Override
    public int update(Passager passager) throws SQLException {
        return passagerDao.update(passager);
    }

    @Override
    public int delete(Passager passager) throws SQLException {
        return passagerDao.delete(passager);
    }

    public void deletePassagerWithContacts(Passager passager) throws SQLException {
        ContactDetailsService contactDetailsService = new ContactDetailsService();
        passagerDao.delete(passager);
        contactDetailsService.delete(passager.getContacts());
    }

    public void printPassager(String id) throws SQLException {
        Optional<Passager> passager = passagerDao.get(id);
        if (passager != null) {
            log.info(passager.get().toString());
        } else {
            log.info("Passager with  " + id + " not found");
        }

    }

    public void printAllPassagers() throws SQLException {
        List<Passager> passagers = passagerDao.getAll();
        passagers.forEach(log::info);
    }
}
