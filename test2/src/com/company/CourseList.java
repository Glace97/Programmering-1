package com.company;

public class CourseList {
    private static final int CAPACITY = 5;
    // kurser

    private Course[] courses;
    // antalet kurser

    private int courseCount;

    public CourseList () {
        courses = new Course[CAPACITY];
        courseCount = 0;
    }

    // add lägger till en kurs i listan
    public void add (Course course) {
        courses[courseCount] = course;
        courseCount++;
    }
    // toString returnerar listans strängrepresentation
    public String toString(){
        String s = "";

        for(int i = 0; i < courseCount; i++) {
            s = s + courses[i] + "\n";
        }
        return s;
    }

    public void remove(Course course) {
        Course[] copy = new Course[CAPACITY];
        int removePos = 0;

        for(int i = 0; i < CAPACITY; i++){
            if(course.equals(this.courses[i])){
                removePos = i;
                courseCount--;
            }
        }

        int pos = 0;
        for(int i = 0; i <  CAPACITY; i++) {
            if(pos == removePos) {
                pos+=1;
                copy[i] = courses[pos];
            }

            copy[i] = courses[pos];
            pos++;
        }

        this.courses = copy;
    }
    // remove tar bort en given kurs från listan.
    // Om kursen inte finns i listan, uppdateras inte listan.
    // koden saknas här
}
