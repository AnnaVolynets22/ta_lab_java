package com.epam.lab.lambdastreams.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Command implements Executor {
    private static Logger logger = LogManager.getLogger(Command.class);
    @Override
    public void execute(String s) {
        logger.info("Executing class method with parameter " + s );
    }
}
