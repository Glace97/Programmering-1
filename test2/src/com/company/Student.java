package com.company;

import java.util.Arrays;

public class Student {
    public static final int    GRADE_COUNT = 4;
    public String    name;
    public int[]    grades;

    public Student (String name) {
        this.name = name;
        grades = new int [GRADE_COUNT];
    }

    // setGrade sätter betyg på den uppgift vars index är givet
    public void setGrade (int gradeIndex, int grade) {
        this.grades[gradeIndex] = grade;
    }

    public String toString() {
        String studentAndGrade;
        return studentAndGrade = "{" + this.name + ": " + Arrays.toString(grades) + "}";
    }

    public double averageGrade() {
        int intSum = 0;

        for(int i = 0; i < GRADE_COUNT; i++){
            intSum += this.grades[i];
        }

        double sum = (double) (intSum);
        return sum/GRADE_COUNT;
    }
}
