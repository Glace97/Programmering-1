package com.company;

public class WordContainer {
    // ord i behållaren
    private String[] words;
    // antalet ord
    int numberOfWords;
    // WordContainer skapar en tom ordbehållare.
    // capacity - antalet positioner i behållaren
    public WordContainer (int capacity)
    {
        if (!(capacity > 0))
            throw new java.lang.IllegalArgumentException ("improper capacity: " + capacity);
        this.words = new String[capacity];
        for (int pos = 0; pos < words.length; pos++)
            this.words[pos] = "-"; // - betecknar en tom position
        numberOfWords = 0;
    }
    public String toString ()
    {
        StringBuilder sb = new StringBuilder ("[ ");
        for (int pos = 0; pos < words.length - 1; pos++)
            sb.append (words[pos] + " | ");
        sb.append (words[words.length - 1] + " ]");
        return sb.toString ();
    }
    // put lägger till ett givet ord på första lediga positionen i behållaren.
    // Om behållaren är full, kastar metoden ett undantag av typen
    // java.lang.IllegalStateException.
    public void put(String input) {
        int numberOfSpaces = words.length;
        for(int i = 0; i < words.length; i++) {
            if(!words[i].equals("-")) {
                numberOfSpaces--;
            }
        }

        if(numberOfSpaces == 0) {
            throw new java.lang.IllegalArgumentException(": Full Container");
        }

        for(int i = 0; i < words.length; i++) {
            if(words[i] == "-"){
                words[i] = input;
                i = words.length-1;
            }
        }
    }
    // take tar det ord i behållaren som finns på en given position, och returnerar det.
    // Om en position som inte finns i behållaren anges, kastas ett undantag av typen
    // java.lang.IndexOutOfBoundsException.
    // Om den angivna positionen är tom, kastas ett undantag av typen
    // java.lang.IllegalArgumentException.
    public String take (int index) {
        if(index >= words.length) {
            throw new java.lang.IndexOutOfBoundsException("Wrong poisition " + index);
        }

        if(words[index].equals("-")) {
            throw new java.lang.IllegalArgumentException("Position " + index + " is empty");
        }

        String chosenWord = words[index];
        words[index] = "-";

        return chosenWord;
    }
}

