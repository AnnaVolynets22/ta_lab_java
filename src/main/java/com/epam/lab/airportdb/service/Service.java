package com.epam.lab.airportdb.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;



public interface Service<T> {
    Optional<T> find(String id) throws SQLException;

    List<T> findAll() throws SQLException;

    int create(T t) throws SQLException;

    int update(T t) throws SQLException;

    int delete(String id) throws SQLException;
}
