package com.company;

import org.w3c.dom.ls.LSOutput;
public class Triangel {

    //Metoden tar 3 sidor på triangel och returnerar omkretsen.
    public static double triangelnsOmkrets(double a, double b, double c){
        double omkrets = a + b +c;

        return omkrets;
    }

    //Metoden tar basen och höjden, returnerar arean.
    public static double triangelnsArea(double bas, double h){
        double area = (bas * h) / 2;

        return area;
    }

    //Metoden tar  2 sidor i triangeln och en vinkel, returnerar triangels bisektrs för det hörnet.
    public static double bisektris (double b, double c, double alfa)  //Ska denna metod anropas i man eller används denna enbart som en exempeluppgift 2.?
    {
        double p = 2 * b * c * Math.cos (alfa / 2);
        double bis = p / (b + c);

        return bis;
    }

    //Metoden tar 3 sidor, a, b, c; och returnerar radien på den omskrivna cirkeln
    public static double omskrivenTriangel(double a, double b, double c){
        double s = (a + b + c) / 2;
        double r = (a * b * c) / (4 * (Math.sqrt ( s * (s-a) * (s-b) * (s-c) ) ));

        return r;
    }

    //Metoden tar 3 sidor a, b, c; och retrnerar radien på den inskrivna cirkeln
    public static double inskrivenTriangel(double a, double b, double c){
        double s = (a + b + c ) / 2;
        double r = Math.sqrt( ((s-a)*(s-b)*(s-c)) / s );

        return r;
    }
}
