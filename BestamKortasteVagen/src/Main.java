import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

        System.out.println("Ange antal stationer U");
        int m = input.nextInt();    //m = i

        System.out.println("Ange antal stationer V");
        int n = input.nextInt();    //n =j

        double xTillU[] = new double[m];   //skapa lista för antalet vägar mellan x och u. Ger också antalet U stationer
        double uTillV[][] = new double [m][n];  //antal vägar mellan u och v
        double vTillY[] = new double [n];  // skapa lista för antalet vägar mellan v och y. Ger också antalet Y stationer


        for(int i = 0; i < m; i++) {                    //populera listan a[]
            System.out.println("Ange längden mellan station X och U"+ (i+1) + ": "); //+1 eftersom indexeringen börjar på 0
            xTillU[i] = input.nextDouble();
        }

        for(int j = 0; j < n; j++) {        //populera listan b[][]
            for( int i = 0; i < m; i++) {

                System.out.println("Ange längden mellan U"+(i+1) +" och" + " V"+(j+1) + " :");
                uTillV[i][j] = input.nextDouble();
            }
        }

        for(int j = 0; j < n; j++) {                    //populera listan c[]
            System.out.println("Ange längden mellan station V" + (j+1) + " och Y: "); //+1 eftersom indexeringen börjar på 0
            vTillY[j] = input.nextDouble();
        }

        DenKortasteVagen kortasteVagen = new DenKortasteVagen();   //skapa objektet

        System.out.println(kortasteVagen.langd(xTillU, uTillV, vTillY));        //anropa metoden med argumenten

        int mellanStaioner [] = kortasteVagen.mellanstationer(xTillU,uTillV,vTillY);
        System.out.println("Den kortaste vägen går igenom mellanstationerna U"+ mellanStaioner[1]+ " och V" + mellanStaioner[2]); //indexeringen börjar på 0, +1 för att förskjuta stationssiffran,
    }
}
