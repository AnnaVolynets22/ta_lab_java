package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.connection.ConnectionHandler;
import com.epam.lab.airportdb.model.Address;
import com.epam.lab.airportdb.model.ContactDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.lab.airportdb.constants.SqlQueryConst.*;

public class ContactDetailsDao implements Dao<ContactDetails> {
    AddressDao addressDao = new AddressDao();

    @Override
    public Optional<ContactDetails> get(String id) throws SQLException {
        ContactDetails contactDetails = null;
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_CONTACT_BY_ID)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Address address = addressDao.get(rs.getString("address")).get();
                    contactDetails = new ContactDetails(rs.getInt("id"), rs.getString("email"),
                            rs.getString("phone"), address);
                }
            }
        }
        return Optional.of(contactDetails);
    }

    @Override
    public List<ContactDetails> getAll() throws SQLException {
        List<ContactDetails> contactDetails = new ArrayList<>();
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_ALL_CONTACTS)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Address address = addressDao.get(rs.getString("address")).get();
                    contactDetails.add(new ContactDetails(rs.getInt("id"), rs.getString("email"),
                            rs.getString("phone"), address));
                }
            }
        }
        return contactDetails;
    }

    @Override
    public int create(ContactDetails contactDetails) throws SQLException {

        return prepareAndExecuteStatement(contactDetails, CREATE_CONTACT);
    }

    @Override
    public int update(ContactDetails contactDetails) throws SQLException {
        return prepareAndExecuteStatement(contactDetails, UPDATE_CONTACT);
    }


    @Override
    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(DELETE_CONTACT)) {
            ps.setString(1, id);
            return ps.executeUpdate();
        }
    }

    private int prepareAndExecuteStatement(ContactDetails contactDetails, String query) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(query)) {
            if (addressDao.get(contactDetails.getAddress().getId().toString()).get() == null) {
                addressDao.create(contactDetails.getAddress());
            }
            ps.setString(1, contactDetails.getEmail());
            ps.setString(2, contactDetails.getPhone());
            ps.setInt(3, contactDetails.getAddress().getId());
            if(query == UPDATE_CONTACT) {
                ps.setInt(4, contactDetails.getId());
            }
            return ps.executeUpdate();
        }
    }
}
