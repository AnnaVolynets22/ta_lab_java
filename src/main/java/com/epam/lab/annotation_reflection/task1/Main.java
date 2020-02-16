package com.epam.lab.annotation_reflection.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Student student = new Student(20,
                "Ivan Ivanov",
                "Kyiv, Ukraine",
                5);
        logger.info(student);
        Class c = student.getClass();
        logger.info(c.toString());

        logger.info("Annotated fields:");
        for(Field field : c.getDeclaredFields()){
            if(field.isAnnotationPresent(MyAnnotation.class)){
                logger.info(field.getType() + " "+ field.getName());
                field.setAccessible(true);
                try {
                    logger.info(field.get(student));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
