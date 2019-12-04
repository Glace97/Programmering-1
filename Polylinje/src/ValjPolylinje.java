import java.sql.SQLOutput;
import java.util.*;

class ValjPolylinje {
    public static final Random rand = new Random ();
    public static final int ANTAL_POLYLINJER = 10;

    public static void main (String[] args) {
        // skapa ett antal slumpmässiga polylinjer
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
        for (int i = 0; i < ANTAL_POLYLINJER; i++)
            polylinjer[i] = slumpPolylinje ();

        // visa polylinjerna
        System.out.println("POLYLINJER:" + "\n");
        for (int i = 0; i < ANTAL_POLYLINJER; i++) {
            System.out.println(polylinjer[i]);
            System.out.println("---------------------------------------------------------------------");
        }

        // bestäm den kortaste av de polylinjer som är gula
        int antalGulaPolylinjer = 0;
        double[] gulLangdKopia = new double[ANTAL_POLYLINJER];
        int plats = 0;

        for (int i = 0; i < ANTAL_POLYLINJER; i++) {
            if (polylinjer[i].getFarg() == "Gul") {
                antalGulaPolylinjer++;

                gulLangdKopia[plats] = polylinjer[i].langd();
                plats++;
            }
        }
        if (antalGulaPolylinjer == 0) {          //om inga gula linjer hittas stänger programmet.
            System.out.println("Inga gula polylinjer hittades.");
            System.exit(0);
        }
        else {
            double[] gulLangd = new double[antalGulaPolylinjer];

            for (int i = 0; i < antalGulaPolylinjer; i++) {
                gulLangd[i] = gulLangdKopia[i];                 //samla alla längder i en lista
            }

            double kortastLangd = gulLangd[0];
            for (int i = 1; i < antalGulaPolylinjer; i++) {
                if ( gulLangd[i] < kortastLangd){
                    kortastLangd = gulLangd[i];
                }
            }
            System.out.println("Den kortaste Gula Polylinjen är: " + kortastLangd + " l.e lång.");
        }

        // visa den valda polylinjen
    }

    // slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
    // det engelska alfabetet, och slumpmässiga koordinater.
    public static Punkt slumpPunkt () {
        String n = "" + (char) (65 + rand.nextInt (26));   //asciencoded, generera random char. // (datatyp) (range, av typen int, fårn 65 till 26, alla stora bokstäver i AASCi)
        int x = rand.nextInt (11);     //punkterna väljs slumpmässigt mellan 0-10
        int y = rand.nextInt (11);
        return new Punkt (n, x, y);
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
    // eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
    // kan inte ha samma namn.
    public static Polylinje slumpPolylinje () {
        // skapa en tom polylinje, och lägg till hörn till den
        Polylinje polylinje = new Polylinje ();
        int antalHorn = 2 + rand.nextInt (7);    //minst 2 antal hörn, upp till 6. Väljs slumpmässigt fram
        int antalValdaHorn = 0;           //antal true positioner i valda namn "hur många unika hörn har vi"
        boolean[] valdaNamn = new boolean[26];

        // ett och samma namn kan inte förekomma flera gånger
        Punkt valdPunkt = null;
        char valtChar = 0;

        while (antalValdaHorn < antalHorn) {   //
            valdPunkt = slumpPunkt();      //väljer den slumpade punkten
            valtChar = valdPunkt.getNamn().charAt(0);   //väljer char som utgör slumpade punktens namn

            //Om en bokstav redan populerat sin plats i listan (satt till true) slumpas en ny punkt fram.
            while(valdaNamn[valtChar-65] == true) {
                valdPunkt = slumpPunkt();
                valtChar = valdPunkt.getNamn().charAt(0);
            }

            valdaNamn[valtChar-65] = true;  //Den genererade punktens char namn sätter sin index plats i listan till true. Ex C=67, plats 3, index 2
            polylinje.laggTill(valdPunkt);
            antalValdaHorn++;              //fram tills vi når antalet punkter i polylinjen körs denna while loop

        }

        // sätt färg
        // String[] valbarFarg = new String[]{"Blå", "Röd", "Gul"};
        int slumpadFarg = rand.nextInt(3); //3 options, kommer genererea 0,1,2

        if (slumpadFarg == 0) {
            polylinje.setFarg("Blå");
        }

        if (slumpadFarg == 1) {
            polylinje.setFarg("Röd");
        }

        if (slumpadFarg == 2){
            polylinje.setFarg("Gul");
        }

        return polylinje;
    }
}
