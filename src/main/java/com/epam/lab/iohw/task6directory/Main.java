package com.epam.lab.iohw.task6directory;

import com.epam.lab.iohw.PropertiesUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        String dirName = PropertiesUtils.getProperty("dirPath");
        CommandLineUtils.displayContentOfDirectory(dirName);
    }
}
