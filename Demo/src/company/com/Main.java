package company.com;

import com.company.MinstaTal;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[]args) {
        int[] element = new int[]{20, 12, 15, 3, 4, 7, 9, 14, 2, 16, 19, 8, 25, 6, 5, 18, 1, 21, 24};

        //Anropa metoden Min som numera använder uppdateringstrategin.
        System.out.println(MinstaTal.min(element));

    }
}