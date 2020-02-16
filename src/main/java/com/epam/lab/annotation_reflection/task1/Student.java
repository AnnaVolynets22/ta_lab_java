package com.epam.lab.annotation_reflection.task1;


public class Student {
    private int studentAge;
    @MyAnnotation
    private String studentName;
    @MyAnnotation
    private String stuAddress;
    private int averageMark;

    public Student(int studentAge, String studentName, String stuAddress, int averageMark) {
        this.studentAge = studentAge;
        this.studentName = studentName;
        this.stuAddress = stuAddress;
        this.averageMark = averageMark;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(String stuAddress) {
        this.stuAddress = stuAddress;
    }

    public int getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(int averageMark) {
        this.averageMark = averageMark;
    }


    @Override
    public String toString() {
        return "MyStudentClass{" +
                "studentAge=" + studentAge +
                ", studentName='" + studentName + '\'' +
                ", stuAddress='" + stuAddress + '\'' +
                ", averageMark=" + averageMark +
                '}';
    }
}
