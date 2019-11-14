import java.util.*; // Scanner
import static java.lang.System.out;
import java.util.Arrays;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {
    public static void main (String[] args) {
        out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
        // mata in två naturliga heltal
        Scanner in = new Scanner(System.in);
        out.println("två naturliga heltal:");
        String tal1 = in.next();
        String tal2 = in.next();
        out.println();
        // addera heltalen och visa resultatet
        String summa = addera(tal1, tal2);
        visa(tal1, tal2, summa, '+');
        // subtrahera heltalen och visa resultatet
        // koden här
    }

    // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
    // summa som en teckensträng.
    public static String addera (String tal1, String tal2) {
        String intTal1 = tal1;       //initialize tal1
        String intTal2 = tal2;       //initialize tal2

        int len1 = intTal1.length ();    //variabeln len1 är lika lång som tal1 längd
        int len2 = intTal2.length ();    //variabeln len2 är lika lång som tal2 längd
        int maxLen = Math.max(len1, len2);   //hitta längsta talet
        int minLen = Math.min(len1, len2);   //hitta minsta talet

        String[] intStringSplit1 = intTal1.split("");    //Split by spaces
        String[] intStringSplit2 = intTal2.split("");    // "-"

        int listaTal1 [] = new int[maxLen]; //Used to store our ints
        int listaTal2 [] = new int [maxLen]; //
        int listaResultat [] = new int[maxLen+1];

        StringBuilder summaSB = new StringBuilder();   //för att skriva ut resultatet i en enda string, från array
        String summa = "";

        for(int i = 0; i < maxLen; i++) {                 //konvertera och splitta varje karaktär (siffra) från string till int.
            listaTal1[i] = Integer.parseInt(intStringSplit1[i]);
            listaTal2[i] = Integer.parseInt(intStringSplit2[i]);
        }

        for (int i = 0; i < maxLen; i++) {     //populera resultatlistan

            if( (listaTal1[maxLen-1] + listaTal2[maxLen-1]) > 9) {
                //här ska det finnas information om vad som händer med carry out
            }

            else {
                listaResultat[i] = listaTal1[i] + listaTal2[i];
            }

            int siffra = listaResultat[i];     //siffran på plats i resultatlistan
            String siffraString [] = new String[maxLen];  // lista som håller string variabler
            siffraString [i] = String.valueOf(siffra);     //Sätt värdet, bakifrån fram

            summa = "" + summaSB.append(siffraString[i]);
        }

        return summa;
    }

    // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
    // deras differens som en teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.
   /* public static String subtrahera (String tal1, String tal2) {

        // koden ska skrivas här
    }
*/
    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
    // utförd i samband med hetalen
    public static void visa (String tal1, String tal2, String resultat, char operator) {
        // sätt en lämplig längd på heltalen och resultatet
        int len1 = tal1.length ();    //variabeln len1 är lika lång som tal1 längd
        int len2 = tal2.length ();    //variabeln len2 är lika lång som tal2 längd
        int len = resultat.length ();   //längden på resultatet
        int maxLen = Math.max (Math.max (len1, len2), len);   //största talet är maxLen, tal1 tal 2 jämförs
        tal1 = sattLen (tal1, maxLen - len1);           //tal1 = metoden sattLen, se längre ner
        tal2 = sattLen (tal2, maxLen - len2);
        resultat = sattLen (resultat, maxLen - len);    //argumentet "resultat" i metoden sätts till maxLen-len
        // visa heltalen och resultatet
        out.println (" " + tal1);
        out.println ("" + operator + " " + tal2);
        for (int i = 0; i < maxLen + 2; i++)
            out.print ("-");
        out.println ();
        out.println (" " + resultat + "\n");
    }

    // sattLen lägger till ett angivet antal mellanslag i början av en given sträng
    public static String sattLen (String s, int antal) {
        StringBuilder sb = new StringBuilder (s);    //skapar objekt
        for (int i = 0; i < antal; i++)
            sb.insert (0, " ");
        return sb.toString ();
    }
}
