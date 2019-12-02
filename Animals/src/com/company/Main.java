package com.company;

public class Main {
    public static void main(String[] args) {
        Cat misse = new Cat();
        Dog doggo = new Dog("Doggo","Dogfood" ,10);
        Duck ducky = new Duck();

        Animal[] animals = new Animal[]{misse, doggo, ducky};

        for ( int i = 0; i < animals.length; i++) {
            animals[i].eat();
            animals[i].shit();
            animals[i].sleep();
        }
    }
}
