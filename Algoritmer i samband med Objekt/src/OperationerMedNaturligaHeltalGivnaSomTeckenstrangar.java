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
        String num1 = "11111111111111111111111111111111111111111111";       //initialize tal1
        String num2 = "10905";       //initialize tal2

        int len1 = num1.length ();    //variabeln len1 är lika lång som tal1 längd
        int len2 = num2.length ();    //variabeln len2 är lika lång som tal2 längd
        int maxLen = Math.max(len1, len2);   //hitta längsta talet, anger längden

        //Gör en array av alla chars från tal1/2
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();

        int intListaNum1 [] = new int[maxLen];         //Used to store our ints  är lika stor som största talet. Det mindre talet populeras med nollor på överblivna platser
        int intListaNum2 [] = new int [maxLen];

        StringBuilder resultatSB = new StringBuilder();    //för att skriva ut resultatet i en enda string, från array
        String resultat = "";
        int carryOut = 0;


        //populera listorna. Tomma platser i listan sätts tll 0 per automatik (i Java).
        for (int i = 1; i <= num1Char.length; i++){
            intListaNum1[maxLen-i] =  Character.getNumericValue(num1Char[num1Char.length-i]);
        }

        for ( int i = 1; i <= num2Char.length; i++){
            intListaNum2[maxLen-i] = Character.getNumericValue(num2Char[num2Char.length-i]);
        }

        //resultatet/additionen
        for (int i = 1; i <= maxLen; i++) {
            if( (carryOut + intListaNum1[maxLen-i] + intListaNum2[maxLen-i]) > 9){
                String overFlow = String.valueOf(carryOut + intListaNum1[maxLen-i] + intListaNum2[maxLen-i]);
                char[] overFlowList = overFlow.toCharArray();
                resultatSB = resultatSB.append( Character.toString(overFlowList[1]) );
                carryOut=1;
            }
            else{
                resultatSB = resultatSB.append(String.valueOf (carryOut + intListaNum1[maxLen-i] + intListaNum2[maxLen-i]) ); //carryout+ sistaplatsen i båda listor konverteras till string och läggs i stringbuidern (dynamiskt växande)
                carryOut = 0;
            }

        }
        resultat = resultatSB.reverse().toString();    //flippa resultatSB, konvertera till string.
        return resultat;                          //returnera string
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
