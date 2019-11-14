package com.company;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Ange b och c, och vinkel i radianer");
        Scanner input= new Scanner(System.in);
        double b = input.nextDouble();
        double c = input.nextDouble();
        double alpha = input.nextDouble();
        Bisektris bisketrisObjekt = new Bisektris();
        System.out.println(bisketrisObjekt.bisektris(b,c, alpha));
    }
}
