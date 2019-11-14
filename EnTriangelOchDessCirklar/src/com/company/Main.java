package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("1.Omkrets" + "\n" + "2.Area" + "\n" +"3.Radien, omskriven cirkeln" + "\n" + "4.Radien, inskriven cirkeln");
        int val = input.nextInt();

        switch (val) {

            case 1:
                System.out.println("Längden på sidorna till triangeln");
                double a = input.nextDouble();
                double b = input.nextDouble();
                double c = input.nextDouble();

                System.out.println(Triangel.triangelnsOmkrets(a, b, c));
                break;

                case 2:
                System.out.println("Basen och höjden: ");
                double bas = input.nextDouble();
                double h = input.nextDouble();

                System.out.println(Triangel.triangelnsArea(bas, h));
                break;

            case 3:
                System.out.println("Tre sidorna på triangeln");
                double x = input.nextDouble();
                double y = input.nextDouble();
                double z = input.nextDouble();

                System.out.println(Triangel.omskrivenTriangel(x, y, z));
                break;

            case 4:
                System.out.println("Tre sidorna på triangeln");
                double p = input.nextDouble();
                double q = input.nextDouble();
                double r = input.nextDouble();

                System.out.println(Triangel.inskrivenTriangel(p,q,r));
                break;
        }
    }
}
