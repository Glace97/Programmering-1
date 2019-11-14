package com.company;

public class Bisektris {
    public static double bisektris (double b, double c, double alfa) {
        double p = 2 * b * c * Math.cos (alfa / 2);
        double bis = p / (b + c);
        return bis;
    }

}
