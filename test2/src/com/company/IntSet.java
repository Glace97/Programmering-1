package com.company;

public class IntSet {
    // element i mängden
    private int[] elements = null;
    // antagande: alla element i argumentvektorn är unika
    public IntSet (int[] elements) {
        this.elements = new int [elements.length];
        for (int pos = 0; pos < elements.length; pos++)
            this.elements[pos] = elements[pos];
    }

    // toString returnerar strängrepresentation av mängden
    public String toString () {
        String s = "{";
        if (elements.length == 0)
            s = s + "}";
        else
        {
            for (int pos = 0; pos < elements.length - 1; pos++)
                s = s + elements[pos] + ", ";
            s = s + elements[elements.length - 1] + "}";
        }
        return s;
    }

    // contains returnerar true om ett givet element finns
    // i mängden, annars false.
    public boolean contains (int element) {
        int contains = 0;
        for ( int i = 0; i < elements.length; i++) {
            if(element == elements[i]) {
                contains = 1;
            }
        }
        if(contains == 1) {
            return  true;
        }
        else {
            return  false;
        }
    }

    // intersection returnerar en mängd som innehåller de
    // element i mängden som även finns i en given mängd
    public IntSet intersection (IntSet set) {
        int countCommonElements = 0;

        for (int pos = 0; pos < elements.length; pos++) {
            if (set.contains(elements[pos]))
                countCommonElements++;
        }

        int[] commonElements = new int[countCommonElements];
        int posC = 0;

        for (int pos = 0; pos < elements.length; pos++) {
            if (set.contains(elements[pos]))
                commonElements[posC++] = this.elements[pos];
        }

        return new IntSet (commonElements);
    }

}
