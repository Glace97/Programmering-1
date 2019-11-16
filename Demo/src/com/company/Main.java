package com.company;
import java.util.Scanner;
import java.util.Arrays;

import static java.lang.System.*;

public class Main{
    public static void main(String[] args) {
        String num1 = "11111111111111111111111111111111111111111111";       //initialize tal1
        String num2 = "10905";       //initialize tal2

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
        int carryOut = 0;


        //populera listorna. Tomma platser i listan sätts tll 0 per automatik (i Java).
        for (int i = 1; i <= num1Char.length; i++){
            intListaNum1[maxLen-i] =  Character.getNumericValue(num1Char[num1Char.length-i]);
        }

        for ( int i = 1; i <= num2Char.length; i++){
            intListaNum2[maxLen-i] = Character.getNumericValue(num2Char[num2Char.length-i]);
        }

        //resultatet/additionen
        for (int i = 1; i <= maxLen; i++) {
            if( (carryOut + intListaNum1[maxLen-i] + intListaNum2[maxLen-i]) > 9){
                String overFlow = String.valueOf(carryOut + intListaNum1[maxLen-i] + intListaNum2[maxLen-i]);
                char[] overFlowList = overFlow.toCharArray();
                resultatSB = resultatSB.append( Character.toString(overFlowList[1]) );
                carryOut=1;
            }
            else{
                resultatSB = resultatSB.append(String.valueOf (carryOut + intListaNum1[maxLen-i] + intListaNum2[maxLen-i]) ); //carryout+ sistaplatsen i båda listor konverteras till string och läggs i stringbuidern (dynamiskt växande)
                carryOut = 0;
            }

        }
        resultat = resultatSB.reverse().toString();    //flippa resultatSB, konvertera till string.
        out.println(resultat);                          //returnera string
    }
}












