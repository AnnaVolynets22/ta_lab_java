package com.epam.lab.lambdastreams.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        MyFunctionalInterface lambda1 = (v1 , v2, v3)->{
            if((v1 >= v2) && (v1>=v3)){
                return v1;
            }else if((v2 >= v1) && (v2 >= v3)){
                return v2;
            } else return v3;
        };

        MyFunctionalInterface lambda2 = (v1 , v2, v3)-> (v1 + v2 +v3)/3;
        int max = lambda1.func(4, 7, 1);
        logger.info("Max value:" + max);

        int average = lambda2.func(4, 7, 1);
        logger.info("Average value:" + average);

    }
}
