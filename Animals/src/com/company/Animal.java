package com.company;

public class Animal {
    int sleep = 15;
    String animal = "animal";
    String food = "meat and bread";
    int shit = 10;

    public void eat(){
        System.out.println(animal + " eats: " + food);
    }

    public void shit() {
        System.out.println(animal+ " shit " + shit  + "times a day");
    }

    public void sleep() {
        System.out.println( animal + " sleeps for " + sleep + " hours.");
    }
}
