package com.epam.lab.stringshw.bigtask.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Const {
    private static final Logger logger = LogManager.getLogger(Const.class);

    public static final String SPACES_REG = "\\s{2,}";
    public static final String SENTENCES_REG = "[^.!?\\s][^.!?]*(?:[.!?](?!['\"]?\\s|$)[^.!?]*)*[.!?]?['\"]?(?=\\s|$)";

    private Const(){
        logger.info("Utils class.");
    }
}
