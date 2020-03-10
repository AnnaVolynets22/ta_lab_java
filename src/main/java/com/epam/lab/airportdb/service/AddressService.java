package com.epam.lab.airportdb.service;

import com.epam.lab.airportdb.dao.AddressDao;
import com.epam.lab.airportdb.model.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AddressService implements Service<Address>{
    private static final Logger log = LogManager.getLogger(CityService.class);

    AddressDao addressDao = new AddressDao();

    @Override
    public Optional<Address> find(String id) throws SQLException {
        return addressDao.get(id);
    }

    @Override
    public List<Address> findAll() throws SQLException {
        return addressDao.getAll();
    }

    @Override
    public int create(Address address) throws SQLException {
        return addressDao.create(address);
    }

    @Override
    public int update(Address address) throws SQLException {
        return addressDao.update(address);
    }

    @Override
    public int delete(Address address) throws SQLException {
        return addressDao.delete(address);
    }

    public void findCityAndPrintInfo(String id) throws SQLException {
        Optional<Address> address = addressDao.get(id);
        if (address != null) {
            log.info(address.get().toString());
        } else {
            log.info("Address with  " + id + " not found");
        }
    }

    public void printAllAddresses() throws SQLException {
        List<Address> addresses = addressDao.getAll();
        addresses.forEach(log::info);
    }
}
