package com.epam.lab.annotation_reflection.task2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyPrintAnnotation {
    String printValue() default "Annotation value";
}
