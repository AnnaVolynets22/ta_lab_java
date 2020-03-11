package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.connection.ConnectionHandler;
import com.epam.lab.airportdb.model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.lab.airportdb.constants.SqlQueryConst.*;

public class CountryDao implements Dao<Country> {
    @Override
    public Optional<Country> get(String id) throws SQLException {
        Country country = null;
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_COUNTRY_BY_NAME)) {
            ps.setString(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    country = new Country(resultSet.getString("country"), resultSet.getBoolean("isEu"));
                }
            }
        }
        return Optional.of(country);
    }

    @Override
    public List<Country> getAll() throws SQLException {
        List<Country> countries = new ArrayList<>();
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_ALL_COUNTRIES)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                while(resultSet.next()) {
                    countries.add((new Country(resultSet.getString("country"), resultSet.getBoolean("isEu"))));
                }
            }
        }
        return countries;
    }

    @Override
    public int create(Country country) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(CREATE_COUNTRY)) {
            ps.setString(1, country.getCountryName());
            ps.setBoolean(2, country.isEu());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(Country country) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(UPDATE_COUNTRY)) {
            ps.setBoolean(1, country.isEu());
            ps.setString(2, country.getCountryName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(String id) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(DELETE_COUNTRY)) {
            ps.setString(1, id);
            return ps.executeUpdate();
        }
    }
}
