package com.epam.lab.airportdb;

import com.epam.lab.airportdb.connection.ConnectionHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {
    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        ConnectionHandler.getConnection();
    }
}
