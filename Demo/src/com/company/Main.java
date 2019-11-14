package com.company;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.out;


import static java.lang.System.out;

public class Main{
    public static void main(String[] args) {
        String intTal1 = "125";       //initialize tal1
        String intTal2 = "164";       //initialize tal2

        int len1 = intTal1.length ();    //variabeln len1 är lika lång som tal1 längd
        int len2 = intTal2.length ();    //variabeln len2 är lika lång som tal2 längd
        int maxLen = Math.max(len1, len2);   //hitta längsta talet
        int minLen = Math.min(len1, len2);   //hitta minsta talet

        String[] intStringSplit1 = intTal1.split(""); //Split by spaces
        String[] intStringSplit2 = intTal2.split("");
        int listaTal1 [] = new int[maxLen]; //Used to store our ints
        int listaTal2 [] = new int [maxLen]; //
        int listaResultat [] = new int[maxLen+1];
        StringBuilder resultatSB = new StringBuilder();   //för att skriva ut resultatet i en enda string, från array
        String resultat = "";

        for(int i = 0; i < minLen ; i++) {                 //konvertera och splitta varje karaktär (siffra) från string till int.
            listaTal1[i] = Integer.parseInt(intStringSplit1[i]);
            listaTal2[i] = Integer.parseInt(intStringSplit2[i]);
        }

        for (int i = 0; i < maxLen; i++) {     //populera resultatlistan

            if ((listaTal1[maxLen - 1] + listaTal2[maxLen - 1]) > 9) {
                //här ska det finnas information om vad som händer med carry out
            }

            else {
                listaResultat[i] = listaTal1[i] + listaTal2[i];
            }

            int siffra = listaResultat[i];     //siffran på plats i resultatlistan
            String siffraString [] = new String[maxLen];  // lista som håller string variabler
            siffraString [i] = String.valueOf(siffra);     //Sätt värdet

            resultat = "" + resultatSB.append(siffraString[i]);

        }
            out.println(resultat);
    }
}