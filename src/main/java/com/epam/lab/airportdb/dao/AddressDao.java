package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.connection.ConnectionHandler;
import com.epam.lab.airportdb.model.Address;
import com.epam.lab.airportdb.model.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.lab.airportdb.constants.SqlQueryConst.*;

public class AddressDao implements Dao<Address> {

    private CityDao cityDao = new CityDao();

    @Override
    public Optional<Address> get(String id) throws SQLException {
        Address address = null;
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_ADDRESS_BY_ID)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    City city = cityDao.get(rs.getString("city")).get();
                    address = new Address(rs.getInt("id"), city, rs.getString("street"),
                            rs.getInt("buildNumber"), rs.getInt("flatNumber"));
                }
            }
        }
        return Optional.of(address);
    }

    @Override
    public List<Address> getAll() throws SQLException {
        List<Address> addresses = new ArrayList<>();
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_ALL_ADDRESSES)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    City city = cityDao.get(rs.getString("city")).get();
                    addresses.add(new Address(rs.getInt("id"), city, rs.getString("street"),
                            rs.getInt("buildNumber"), rs.getInt("flatNumber")));
                }
            }
        }
        return addresses;
    }

    @Override
    public int create(Address address) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(CREATE_ADDRESS)) {
            if (cityDao.get(address.getCity().getId().toString()).get() == null) {
                cityDao.create(address.getCity());
            }
            ps.setInt(1, address.getCity().getId());
            ps.setString(2, address.getStreet());
            ps.setInt(3, address.getBuildNumber());
            ps.setInt(4, address.getFlatNumber());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Address address) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(UPDATE_ADDRESS)) {
            if (cityDao.get(address.getCity().getId().toString()).get() == null) {
                cityDao.create(address.getCity());
            }
            ps.setInt(1, address.getCity().getId());
            ps.setString(2, address.getStreet());
            ps.setInt(3, address.getBuildNumber());
            ps.setInt(4, address.getFlatNumber());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Address address) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(DELETE_ADDRESS)) {
            ps.setString(1, address.getId().toString());
            return ps.executeUpdate();
        }
    }
}
