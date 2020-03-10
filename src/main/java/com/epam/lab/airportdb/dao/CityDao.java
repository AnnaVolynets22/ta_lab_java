package com.epam.lab.airportdb.dao;

import com.epam.lab.airportdb.connection.ConnectionHandler;
import com.epam.lab.airportdb.model.City;
import com.epam.lab.airportdb.model.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.epam.lab.airportdb.constants.SqlQueryConst.*;

public class CityDao implements Dao<City> {

    private CountryDao countryDao = new CountryDao();

    @Override
    public Optional<City> get(String id) throws SQLException {
        City city = null;
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_CITY_BY_ID)) {
            ps.setString(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    Country country = countryDao.get(resultSet.getString("cityCountry")).get();
                    city = new City(resultSet.getInt("id"), resultSet.getString("cityName"), country);
                }
            }
        }
        return Optional.of(city);
    }

    @Override
    public List<City> getAll() throws SQLException {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(FIND_ALL_CITIES)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    Country country = countryDao.get(resultSet.getString("cityCountry")).get();
                    cities.add((new City(resultSet.getInt("id"), resultSet.getString("cityName"), country)));
                }
            }
        }
        return cities;
    }

    @Override
    public int create(City city) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(CREATE_CITY)) {
            ps.setString(1, city.getCityName());
            ps.setString(2, city.getCityCountry().getCountryName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(City city) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(UPDATE_CITY)) {
            ps.setString(1, city.getCityName());
            ps.setString(2, city.getCityCountry().getCountryName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(City city) throws SQLException {
        try (PreparedStatement ps = ConnectionHandler.getConnection().prepareStatement(DELETE_CITY)) {
            ps.setString(1, city.getId().toString());
            return ps.executeUpdate();
        }
    }
}
