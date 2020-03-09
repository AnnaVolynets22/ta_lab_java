package com.epam.lab.airportdb.constants;

public final class DataPropConsts {
    //MySQL
    public static final String JDBC_DRIVER = "jdbc.driver";
    public static final String DB_URL = "mysql.url";
    public static final String DB_NAME = "mysql.database";
    public static final String DB_PORT = "mysql.port";
    public static final String DB_USER = "mysql.user";
    public static final String DB_PASSWORD = "mysql.password";
    public static final String DB_HOST = "mysql.host";


    private DataPropConsts(){
        throw  new IllegalStateException("Utility class");
    }
}
