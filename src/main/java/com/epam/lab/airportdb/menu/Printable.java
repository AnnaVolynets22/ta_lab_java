package com.epam.lab.airportdb.menu;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

@FunctionalInterface
public interface Printable {
    void print() throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException,
            IllegalAccessException;
}
