package com.company;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static void main(String[] args) {
        NaturalNumberBuilder builder = new NaturalNumberBuilder (2, 5);
        System.out.println (builder);
        builder.append (1);
        builder.append (6); // (1)

        System.out.println (builder);
        System.out.println ();
        builder.append (55); // (2)
        int number = builder.getNumber ();

        System.out.println (number);
        builder = new NaturalNumberBuilder ();
        number = builder.getNumber (); // (3)

    }
}
