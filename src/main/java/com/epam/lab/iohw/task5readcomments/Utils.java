package com.epam.lab.iohw.task5readcomments;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
    private static final Logger logger = LogManager.getLogger(Utils.class);

    public static void printAllComments(String filePath){
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.trim().startsWith("//")){
                    logger.info(line.trim());
                }else if(line.trim().contains(";//")){
                    String[] strs = line.split(";");
                    logger.info(strs[1]);
                }else if(line.trim().startsWith("/*")){
                    do{
                        logger.info(line);
                        line = br.readLine();
                    }while (!line.endsWith("*/"));
                    logger.info(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
