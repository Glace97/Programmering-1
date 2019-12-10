package com.company;
import java.util.Arrays;

public class Min2 {
    public static void main(String[] args) {
// min returnerar det minsta elementet i en sekventiell samling.
// Om samlingen är tom, kastas ett undantag av typen IllegalArgumentException.

        int[] element = new int[]{20, 12, 15, 3, 4, 7, 9, 14, 2, 16, 19, 8, 25, 6, 5, 18, 1, 21, 24};

        if (element.length == 0)
            throw new IllegalArgumentException("tom samling");
        // hör ihop med spårutskriften 2:
        int antalVarv = 1;
        int[] sekvens = element;
        int antaletPar = sekvens.length / 2;
        int antaletOparadeElement = sekvens.length % 2;
        int antaletTankbaraElement = antaletPar + antaletOparadeElement;
        int[] delsekvens = new int[antaletTankbaraElement];
        int i = 0;
        int j = 0;


        while (sekvens.length > 1) {
            System.out.println ("Sekvensen i början av loop nr " + antalVarv++ + ": " + java.util.Arrays.toString (sekvens));
            // skilj ur en delsekvens med de tänkbara elementen
            i=0;
            j=0;
            while (j < antaletPar) {
                delsekvens[j++] = (sekvens[i] < sekvens[i + 1]) ? sekvens[i] : sekvens[i + 1];
                i += 2;
            }

            if (antaletOparadeElement == 1)
                delsekvens[j] = sekvens[sekvens.length-1];
            // utgå nu ifrån delsekvensen


            //För att inte tappa något från minnet med dublettreferenser
            sekvens = Arrays.copyOf(delsekvens, delsekvens.length);

            antaletPar = antaletTankbaraElement / 2;
            antaletOparadeElement = antaletTankbaraElement % 2;
            antaletTankbaraElement = antaletPar + antaletOparadeElement;

            //Efter spårning och felsökning av program -> skapa en ny lista med rätt antal platser
            //En ny lista med hälften(+ eventuellt oparade element) så många element.
            delsekvens = new int[antaletTankbaraElement];


            // spårutskrift 1 – för att följa sekvensen
            System.out.println (java.util.Arrays.toString (sekvens));

            // spårutskrift 2 - för att avsluta loopen i förväg
            // (för att kunna se vad som händer i början)
            // if (antalVarv++ == 10)
            // System.exit (0);

        }
        System.out.println(sekvens[0]);
    }
    // sekvens[0] är det enda återstående tänkbara elementet/
    // / - det är det minsta elementet
}