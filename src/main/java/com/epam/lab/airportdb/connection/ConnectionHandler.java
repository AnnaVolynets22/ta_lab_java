package com.epam.lab.airportdb.connection;

import com.epam.lab.airportdb.utils.DataProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {
    private static final Logger log = LogManager.getLogger(ConnectionHandler.class);

    private static DataProperties props = new DataProperties();
    private static Connection connection;

    private ConnectionHandler() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (ConnectionHandler.class) {
                try {
                    Class.forName(props.jdbcDriver());
                    log.debug("Try connect to \'" + props.dbName()
                            + "\' with user: \'" + props.dbUser() + "\' and password: \'" + props.dbPass() + "\' ...");

                    connection = DriverManager.getConnection(props.sqlURL(), props.dbUser(), props.dbPass());
                    log.debug("Connected to \'" + props.dbName() + "\' database successfully!");
                } catch (ClassNotFoundException e) {
                    log.error("Class \'" + props.jdbcDriver() + "\' not found!");
                    e.printStackTrace();
                } catch ( SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                log.debug("DB connection was closed successfully!");
            } catch (SQLException e) {
                log.error("Database access error occurs! Cannot close Connection!!!");
            }
        }
    }
}
