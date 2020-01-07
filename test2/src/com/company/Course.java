package com.company;

public class Course {

    // kursens nummer och namn
    private int number;
    private String name;

    public Course (int number, String name) {
        this.number = number;
        this.name = name;
    }

    public String toString () {
        return "<" + this.number + ", " + this.name + ">";
    }

    // equals returnerar true om kursen är lika
    // med en given kurs, annars false.
    public boolean equals (Course course) {
        return this.number == course.number
                && this.name.equals(course.name);
    }

}
