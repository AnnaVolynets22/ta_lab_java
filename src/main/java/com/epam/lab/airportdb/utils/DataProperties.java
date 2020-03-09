package com.epam.lab.airportdb.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static com.epam.lab.airportdb.constants.DataPropConsts.*;

public class DataProperties {
    private Properties props = new Properties();

    public DataProperties() {
        FileInputStream fis;

        try {
            fis = new FileInputStream("src/main/resources/data.properties");
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String dbHost() {
        return props.getProperty(DB_HOST);
    }

    private int dbPort() {
        return Integer.parseInt(props.getProperty(DB_PORT));
    }

    public String dbName() {
        return props.getProperty(DB_NAME);
    }

    public String dbUser() {
        return props.getProperty(DB_USER);
    }

    public String dbPass() {
        return props.getProperty(DB_PASSWORD);
    }

    public String jdbcDriver() {
        return props.getProperty(JDBC_DRIVER);
    }

    public String sqlURL() {
        return String.format(props.getProperty(DB_URL), dbHost(), dbPort(), dbName());
    }
}
