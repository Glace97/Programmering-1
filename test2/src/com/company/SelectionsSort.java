package com.company;

public class SelectionsSort {
    public static int[] sortElements(int[] element){
        for (int i = 0; i < element.length - 1; i++) {    //är vår First pekare, kommer peka från första till näst sista
            int index = i;                                 //index är vår currentMin pekare
            for (int j = i + 1; j < element.length; j++) {   //j är vår currentItem pekare
                if (element[j] < element[index])            //om currentitem är större än min item
                    index = j;                              //CurrentMin flyttar til Current item
                                                            //körs tills listan kollats igenom, j når sista index
            }
            int smallerNumber = element[index];             //place holder för vårt minsta tal
            element[index] = element[i];                    //det större talet som var First flyttar till platsen där minsta talet är
            element[i] = smallerNumber;                     //First som ska vara på vår sorterade vänstersida får det minsta talet swapped
        }

        return element;
    }
}
