package com.epam.lab.airportdb.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(String id) throws SQLException;

    List<T> getAll() throws SQLException;

    int create(T t) throws SQLException;

    int update(T t) throws SQLException;

    int delete(String id) throws SQLException;
}
