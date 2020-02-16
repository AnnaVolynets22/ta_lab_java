package com.epam.lab.annotation_reflection.task2_4_5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Student student = new Student(20,
                "Ivan Ivanov",
                "Kyiv, Ukraine",
                5);
        logger.info(student);
        Class c = student.getClass();
        logger.info(c.toString());

        logger.info("Annotated fields:");
        for (Field field : c.getDeclaredFields()) {
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                logger.info(field.getType() + " " + field.getName());
                field.setAccessible(true);
                try {
                    logger.info(field.get(student));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("Change name by invoking method setStudentName");
        Method methodSetName = c.getDeclaredMethod("setStudentName", String.class);
        Student student1 = (Student) methodSetName .invoke(student, "Roman Romanov");
        logger.info(student);

        Field field = c.getDeclaredField("studentAge");
        field.setAccessible(true);
        field.set(student, 18);
        logger.info(student);
    }
}
