package com.epam.lab.iohw.task5readcomments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        Properties pro = new Properties();
        InputStream is = Main.class.getClassLoader().getResourceAsStream("path.properties");
        pro.load(is);
        String filePath = pro.getProperty("javaFilePath");
        Utils.printAllComments(filePath);
    }
}
