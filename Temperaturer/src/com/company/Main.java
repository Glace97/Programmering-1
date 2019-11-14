package com.company;
import java.util.*; // Scanner, Locale
class Main
{
    public static void main (String[] args)
    {
        System.out.println ("TEMPERATURER\n");
        // inmatningsverktyg
        Scanner in = new Scanner (System.in);
        //formatet för temperaturen som matas in
        in.useLocale (Locale.US);
        // mata in uppgifter om antalet veckor och antalet mätningar
        System.out.print ("antalet veckor: ");
        int antalVeckor = in.nextInt ();
        System.out.print ("antalet mätningar per vecka: ");
        int antalMatningarPerVecka = in.nextInt ();
        // plats att lagra temperaturer. Tvådimensionell array, har listor i listan. 1a anger rad, andra bracket anger element(kolumn)
        //+1 för den slutgiltiga sammanlagda resultatet av alla veckor
        double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];
        // mata in temperaturerna
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            System.out.println ("temperaturer - vecka " + vecka + ":");
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++) {
                t[vecka][matning] = in.nextDouble ();
            }
        }
        System.out.println ();
        // visa temperaturerna
        System.out.println ("temperaturerna:");
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++) {
                System.out.print (t[vecka][matning] + " ");
            }
            System.out.println ();
        }

        // den minsta, den största och medeltemperaturen – veckovis. Allocate the array with antalveckor+1(antal element)
        double[] minT = new double[antalVeckor + 1];
        double[] maxT = new double[antalVeckor + 1];
        double[] sumT = new double[antalVeckor + 1];
        double[] medelT = new double[antalVeckor + 1];

        // koden ska skrivas här
        // visa den minsta, den största och medeltemperaturen för varje vecka
        for(int vecka = 1; vecka <= antalVeckor; vecka++) {
            minT[vecka]=t[vecka][1];
            maxT[vecka]=t[vecka][1];
            for(int matning = 1; matning <= antalMatningarPerVecka; matning++) {
               if (minT[vecka] > t[vecka][matning]) {
                   minT[vecka] = t[vecka][matning];
               }
               if (maxT[vecka] < t[vecka][matning]) {
                   maxT[vecka] = t[vecka][matning];
               }
               sumT[vecka]+=t[vecka][matning];
            }
            medelT[vecka]=sumT[vecka]/antalMatningarPerVecka;
        }
        for (int vecka = 1; vecka <= antalVeckor; vecka++){
            System.out.println("\n"+"Minsta temperaturen vecka " + vecka +": " + minT[vecka]);
            System.out.println("Maxtemperaturen vecka " + vecka +": " + maxT[vecka]);
            System.out.println("Summa för vecka " + vecka +": " + sumT[vecka]);
            System.out.println("Medeltemperatur för vecka "+ vecka + ": " + medelT[vecka] + "\n");
        }

        // koden ska skrivas här
        // den minsta, den största och medeltemperaturen - hela mätperioden
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];
        double medelTemp = 0;
        for(int vecka=2; vecka <= antalVeckor; vecka++){
            if(minT[vecka] < minTemp){
                minTemp=minT[vecka];
            }
            if(maxT[vecka] > maxTemp){
                maxTemp = maxT[vecka];
            }
            sumTemp += sumT[vecka];
        }
        medelTemp = (sumTemp) / (antalVeckor*antalMatningarPerVecka);

        System.out.println("Minsta temperatur under hela mätperioden: " + minTemp + "\n" +"Maxtemperatur under hela mätperioden: " + maxTemp + "." + "\n" + "Medeltemp för hela perioden: " + medelTemp );
    }
}