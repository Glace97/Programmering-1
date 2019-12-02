package com.company;

public class Cat extends Animal {
    /*String animal = "Cat";
    String food = "mice";
    int shit = 10;
*/
    //konstruktor
    /*public Cat (String a, String f, int s) {
        this.animal = a;
        this.food = f;
        this.shit = s;
    }*/

    @Override
    public void eat () {
        System.out.println(animal + " eats: " + food);
    }

    @Override
    public void shit() {
        System.out.println(animal + " shits " + shit + " times a day.");
    }

}
