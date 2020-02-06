package com.epam.lab.generics.task3priorityqueue;

class Student implements Comparable<Student>{
    private String name;
    private double mark;

    public Student(String name, double mark) {

        this.name = name;
        this.mark = mark;
    }

    public double getMark(){
        return mark;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " " + mark;
    }

    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
    }
}
