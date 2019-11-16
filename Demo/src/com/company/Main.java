package com.company;
import java.util.Scanner;
import java.util.Arrays;

import static java.lang.System.*;

public class Main{
    public static void main(String[] args) {
        String num1 = "938471";     //initialize tal1
        String num2 = "321957";

        int len1 = num1.length ();    //variabeln len1 är lika lång som tal1 längd
        int len2 = num2.length ();    //variabeln len2 är lika lång som tal2 längd
        int maxLen = Math.max(len1, len2);   //hitta längsta talet, anger längden

        //Gör en array av alla chars från tal1/2
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();

        int intListaNum1 [] = new int[maxLen];         //Used to store our ints  är lika stor som största talet. Det mindre talet populeras med nollor på överblivna platser
        int intListaNum2 [] = new int [maxLen];

        StringBuilder resultatSB = new StringBuilder();    //för att skriva ut resultatet i en enda string, från array
        String resultat = "";

        int carryIn = 0;
        //populera listorna
        for (int i = 1; i <= num1Char.length; i++) {
            intListaNum1[maxLen-i] =  Character.getNumericValue(num1Char[num1Char.length-i]);
        }

        for ( int i = 1; i <= num2Char.length; i++) {
            intListaNum2[maxLen-i] = Character.getNumericValue(num2Char[num2Char.length-i]);
        }

        //subtraktionen, metoden kallas enbart om num1 > num2
        for( int i = 1; i <= maxLen; i++) {
            if( intListaNum1[maxLen-i] < intListaNum2[maxLen-i]){
                String nySiffra = "1" + String.valueOf(intListaNum1[maxLen-i]);
                intListaNum1[maxLen-i] = Integer.parseInt(nySiffra);
                resultatSB = resultatSB.append(intListaNum1[maxLen-i] - intListaNum2[maxLen-i]);
                carryIn = -1;
            }
            else{

                resultatSB = resultatSB.append(String.valueOf(carryIn + intListaNum1[maxLen-i]- intListaNum2[maxLen-i]));
                carryIn = 0;
            }
        }
        resultat = resultatSB.reverse().toString();    //flippa resultatSB, konvertera till string.

    }
}












