package com.epam.lab.stringshw.stringutils1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringUtils {
    private static final Logger logger = LogManager.getLogger(StringUtils.class);

    public static String concatParams(Object... params){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<params.length; i++){
            sb.append(params[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        logger.info(concatParams("A", 1, 5.2, "Bbb"));
        logger.info(concatParams(10, 15));
    }
}
