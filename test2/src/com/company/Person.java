package com.company;

public class Person {

    private String name;
    private int birthYear;

    public Person (String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String toString () {
        return "<" + name + ", " + birthYear + ">";
    }

    public int age () {
        java.time.LocalDate currentDate = java.time.LocalDate.now ();
        int currentYear = currentDate.getYear ();
        return currentYear - birthYear;
    }

    public static double averageAge(Person [] persons){
        double averageAge = 0;

        for(int i = 0; i < persons.length; i++) {
            averageAge += persons[i].age();
        }
        return  (averageAge/persons.length);
    }

    public static Person youngestPerson(Person[] persons) {
        int minAge = persons[0].age();
        int youngestPersonIndex = 0;

        for(int i = 1; i < persons.length; i++) {
            if( persons[i].age() < minAge) {
                youngestPersonIndex = i;
            }
        }
        return persons[youngestPersonIndex];
    }
}
