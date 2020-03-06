package com.epam.lab.stringshw.bigtask.utils;

import com.epam.lab.stringshw.bigtask.Main;

import java.io.IOException;
        import java.io.InputStream;
        import java.util.Properties;

public class PropertyUtils {
    public static String getProperty(String propertyName) throws IOException {
        Properties pro = new Properties();
        InputStream is = Main.class.getClassLoader().getResourceAsStream("path.properties");
        pro.load(is);
        return pro.getProperty(propertyName);
    }
}
