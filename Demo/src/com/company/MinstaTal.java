package com.company;

public class MinstaTal {
    // min returnerar det minsta elementet i en sekventiell samling.
// Om samlingen är tom, kastas ett undantag av typen IllegalArgumentException.

    public static int min (int[] element) throws IllegalArgumentException {             //tar element som argument
        if (element.length == 0)
            throw new IllegalArgumentException("tom samling");

        int[] sekvens = element;                                            //sekvens är en kopia av element
        int minstaAktuellaTalet = sekvens[0];

        //Uppdateringstrategin
        for (int i = 0; i < element.length; i++) {
            if(sekvens[i] < minstaAktuellaTalet) {
                minstaAktuellaTalet = sekvens[i];
            }
        }
        return minstaAktuellaTalet;
    }
}
