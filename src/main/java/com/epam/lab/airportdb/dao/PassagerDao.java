package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.connection.ConnectionHandler;
import com.epam.lab.airportdb.model.ContactDetails;
import com.epam.lab.airportdb.model.Passager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.lab.airportdb.constants.SqlQueryConst.*;

public class PassagerDao implements Dao<Passager> {
    private ContactDetailsDao contactDetailsDao = new ContactDetailsDao();

    @Override
    public Optional<Passager> get(String id) throws SQLException {
        Passager passager = null;
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_PASSAGER_BY_ID)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    ContactDetails contactDetails = contactDetailsDao.get(rs.getString("contacts")).get();
                    passager = new Passager(rs.getInt("id"), rs.getString("secontName"),
                            rs.getString("firstName"), rs.getString("nationality"), rs.getInt("age"),
                            contactDetails);
                }
            }
        }
        return Optional.of(passager);
    }

    @Override
    public List<Passager> getAll() throws SQLException {
        List<Passager> passagers = new ArrayList<>();
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_ALL_PASSAGERS)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ContactDetails contactDetails = contactDetailsDao.get(rs.getString("contacts")).get();
                    passagers.add(new Passager(rs.getInt("id"), rs.getString("secontName"),
                            rs.getString("firstName"), rs.getString("nationality"), rs.getInt("age"),
                            contactDetails));
                }
            }
        }
        return passagers;
    }

    @Override
    public int create(Passager passager) throws SQLException {

        return prepareAndExecuteStatement(passager, CREATE_PASSAGER);
    }

    @Override
    public int update(Passager passager) throws SQLException {

        return prepareAndExecuteStatement(passager, UPDATE_PASSAGER);
    }

    @Override
    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(DELETE_PASSAGER)) {
            ps.setString(1, id);
            return ps.executeUpdate();
        }
    }

    private int prepareAndExecuteStatement(Passager passager, String query) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(query)) {
            if (contactDetailsDao.get(passager.getContacts().getId().toString()).get() == null) {
                contactDetailsDao.create(passager.getContacts());
            }
            ps.setString(1, passager.getSecondName());
            ps.setString(2, passager.getFirstName());
            ps.setString(3, passager.getNationality());
            ps.setInt(4, passager.getAge());
            ps.setInt(5, passager.getContacts().getId());
            return ps.executeUpdate();
        }
    }
}
