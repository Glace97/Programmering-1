package com.company;

public class Duck extends Animal {
    String animal = "Duck";
    String food = "breadcrumbs";
    int shit = 20;

    //konstruktor
   /* public Duck (String a, String f, int s) {
        this.animal = a;
        this.food = f;
        this.shit = s;
    }*/

    @Override
    public void eat () {
        System.out.println(animal + " eats: " + food);
    }

    public void shit() {
        System.out.println(animal + " shits " + shit + " times a day.");
    }
}
