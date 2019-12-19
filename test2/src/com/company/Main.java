package com.company;

public class Main {

    public static void main(String[] args) {
	   Student student1 = new Student("Glacier Ali");
	   student1.setGrade(0, 3);
	   student1.setGrade(1, 4);
	   student1.setGrade(2, 5);
	   student1.setGrade(3, 5);

		System.out.println(student1);
		System.out.println(student1.averageGrade());

    }
}
