package com.epam.lab.annotation_reflection.task2;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@MyPrintAnnotation(printValue = "Class print value")
public class Main {
    public static void main(String[] args) {
        Class ca = MyPrintAnnotation.class;
        try {
            Method method = ca.getDeclaredMethod("printValue");
            String printDefaultValue = (String) method.getDefaultValue();
            System.out.println(printDefaultValue);
            
            Object classValue = method.invoke(Main.class.getAnnotation(ca), (Object[]) null);
            System.out.println(classValue);

        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
