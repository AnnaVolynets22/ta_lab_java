package com.epam.lab.generics.task3priorityqueue;

import java.util.Comparator;

class StudentComparator implements Comparator<Student> {

    public int compare(Student s1, Student s2) {
        if (s1.getMark() < s2.getMark())
            return 1;
        else if (s1.getMark() > s2.getMark())
            return -1;
        return 0;
    }
}
