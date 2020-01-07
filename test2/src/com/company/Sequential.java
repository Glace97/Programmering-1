package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

public class Sequential {
    public static void main(String[] args) {
        int[] sekvenslista = new int[]{23,77,91,53,52,43,71,50};
        System.out.println(sequentialSearch(sekvenslista, 52));
    }

    public static int sequentialSearch(int[] sekvens, int element){
        int i = 0;
        //loopen bryts när elementet hittas, andra vilkoret uppfylls ej. Loopen fortsätter köras tills i = sek.len
        while( i < sekvens.length && sekvens[i] != element) {
            if(sekvens[i] == element){
                return i;
            }
            i++;
        }
        if( i == sekvens.length){
            i= -1;                 //om elementet inte finns i listan returneras -1, utanför listan.
        }
        return i;
    }
}
