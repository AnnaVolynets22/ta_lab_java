package com.epam.lab.annotation_reflection.task2;


import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        Class c = MyPrintAnnotation.class;
        Method method = c.getDeclaredMethod("printValue");
        String printValue = (String) method.getDefaultValue();
        System.out.println(printValue);
    }
}
