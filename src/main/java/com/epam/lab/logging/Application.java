package com.epam.lab.logging;

import org.apache.logging.log4j.*;
public class Application {
    private static Logger logger1 = LogManager.getLogger(Application.class);
    public static void main(String[] args) {
        logger1.trace("This is a trace message");
        logger1.debug("This is a debug message");
        logger1.info("This is an info message");
        logger1.warn("This is a warn message");
        logger1.error("This is an error message");
        logger1.fatal("This is a fatal message");
    }
}
