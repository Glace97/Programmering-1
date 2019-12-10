package com.company;
import java.util.Arrays;

public class Min1 {
        public static void main(String[] args) {
// min returnerar det minsta elementet i en sekventiell samling.
// Om samlingen är tom, kastas ett undantag av typen IllegalArgumentException.

            int[] element = new int[]{20, 12, 15, 3, 4, 7, 9, 14, 2, 16, 19, 8, 25, 6, 5, 18, 1, 21, 24};

            if (element.length == 0)
                throw new IllegalArgumentException("tom samling");
            // hör ihop med spårutskriften 2:
            // int antalVarv = 1;
            int[] sekvens = element;
            int antaletPar = sekvens.length / 2;
            int antaletOparadeElement = sekvens.length % 2;
            int antaletTankbaraElement = antaletPar + antaletOparadeElement;
            int[] delsekvens = new int[antaletTankbaraElement];
            int i = 0;
            int j = 0;

            int t = 1;

            while (antaletPar > 0) {                        //Denna whileloop  ändrades från sekvens.lenght > 1 till detta.
                System.out.println("Början på första while loopen.. Så här många gånger körs jag: " + t++);
                System.out.println ("Sekvens Innan kopiering: " + java.util.Arrays.toString (sekvens));
                System.out.println("Antal oparade element:" + antaletOparadeElement);

                // skilj ur en delsekvens med de tänkbara elementen
                i=0;
                j=0;
                while (j < antaletPar) {
                    delsekvens[j++] = (sekvens[i] < sekvens[i + 1]) ? sekvens[i] : sekvens[i + 1];
                    i += 2;

                    System.out.println("Nu är vi i loopen" +"\n" + "Delsekvens[" + (j-1) +"] =" + delsekvens[j-1] + " och sekvens["+ (j-1) + "] =" + sekvens[j-1]);
                }

                //Sekvenslistans längd stämmer inte atm, som vi förväntar oss. Vi vet däremot att j=antalpar i denna if-statement
                //Sekvens (ska egentligen) vara dubbel så lång. Om vi vill ha sista platsen för en dubbelt så lång lista -> sekvens[j*2], och delsekvens[j]
                //anger sista platsen.
                if (antaletOparadeElement == 1)
                    delsekvens[j] = sekvens[j*2];       //FÖRSTA FELET
                // utgå nu ifrån delsekvensen

                sekvens = Arrays.copyOf(delsekvens, delsekvens.length);  //Sekvens och delsekvens blir duplicate refrences, väljer att kopiera ist (i samband med andra felet)

                antaletPar = antaletTankbaraElement / 2;
                antaletOparadeElement = antaletTankbaraElement % 2;
                antaletTankbaraElement = antaletPar + antaletOparadeElement;

                // spårutskrift 1 – för att följa sekvensen
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
