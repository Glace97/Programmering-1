package com.company;

public class Dog extends Animal {
    //String animal = "Dog";
    //String food = "canned dogfood";
    //int shit = 5;

    //konstruktor
    public Dog (String a, String f, int s) {
        this.animal = a;
        this.food = f;
        this.shit = s;
    }

    @Override
    public void eat () {
        System.out.println(animal + " eats: " + food);
    }

    @Override
    public void shit() {
        System.out.println(animal + " shits " + shit + " times a day.");
    }

}
