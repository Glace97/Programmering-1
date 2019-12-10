import org.w3c.dom.ls.LSOutput;
import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

public class Polylinje{

    //privata variabler behöver setter och getters
    private Punkt[] horn;      //Lista skapas med "Punkt" som datatyp.  hörn är referensen
    private int bredd = 1;
    private String  farg= "Svart";

    //initiera
    public Polylinje () {
        this.horn = new Punkt[0];
    }

    //konstruktor Polylinje tar punkter som argument
    public Polylinje (Punkt[] horn) {
        this.horn = new Punkt[horn.length];      //Sätter in vad vi får som argument till längden på listan
        for (int i = 0; i < horn.length; i++)    //från 0 till sista platsen i listan, lägger vi in p1 -> pn på listan
            this.horn[i] = new Punkt (horn[i]);
    }

    //metod för att skriva ut i en fin sträng
    public String toString () {
        String polyLinje = "[";

        for ( int i = 0; i < this.horn.length; i++){
            polyLinje = polyLinje + this.horn[i];
        }
        polyLinje = polyLinje + "]" + "Färg: " + this.farg + ".  Bredd: " + this.bredd;
        return polyLinje;
    }

    public Punkt[] getHorn () {   //returnerar referens (till hörnen).
        Punkt[] h = new Punkt[this.horn.length];    //skapar referens h, + nytt objekt
        for( int i = 0; i < this.horn.length; i++ ) {
          h[i] = new Punkt(this.horn[i]);               //nytt objekt skapas för varje h[i].
        }
        return h;
    }

    //hämta färgen, "svart" om ingen använder setmetoden och ändrar
    public String getFarg () {
        return this.farg;
    }

    //hämta beredden, "1" om ingen använder setBredd och ändrar.
    public int getBredd () {
        return this.bredd;
    }

    //ändra färgen om man inte vill ha svart. Tar "farg" som argument och sätter om privata variabeln "farg"
    public void setFarg (String farg) {
        this.farg = farg;
    }

    //default 1, metoden tar bredd som argument (int) och sätter om variabeln.
    public void setBredd (int bredd) {
        this.bredd = bredd;
    }

    //returnerar längden på polylinjen
    public double langd () {
        double langd = 0;
        for (int i = 0; i < horn.length - 1; i++) {
            langd = langd + horn[i].avstand(horn[i + 1]);       //räknar ut avståndet mha metoden från klassen Punkt
        }
        return langd;
    }

    //metoden för att skapa punkterna till punktlistan
    public void laggTill (Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];    //skapar en lista med en till plats för punkten som ska läggas till
        int i = 0;
        for (i = 0; i < this.horn.length; i++)          // kopierar tidigare punkten in i listans första platser
            h[i] = this.horn[i];
        h[i] = new Punkt (horn);
        this.horn = h;                                  //sätter nya punkten på sista platsen
    }


    //metoden tar ett hörn som vi vill lägga en ny/befintlig punkt framför. Arg är alltså det hörnet som kommer petas ett steg närmare listans slut
    public void laggTillFramfor (Punkt horn, String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length];
        Punkt[] hKopia = new Punkt[this.horn.length];

        int plats = 0;
        //kopierar tidigare hörn i listan
        for(int i = 0; i <this.horn.length; i++) {
            hKopia[i] = this.horn[i];
            h[i] = this.horn[i];

            if( hornNamn == h[i].getNamn() ){      //platsen ges till nya punkten
               hKopia[i] = horn;
               plats = i;
            }
        }
            hKopia[plats+1] = h[plats];

        this.horn = hKopia;   //THIS variabeln får ett nytt värde/lista.
    }

    public void taBort (String hornNamn) {
        Punkt[] h = new Punkt[this.horn.length];

        //kopierar tidigare hörn i listan
        for(int i = 0; i <this.horn.length; i++) {
            h[i] = this.horn[i];

            if( hornNamn == h[i].getNamn() ){      //platsen ges till nya punkten
                h[i] = this.horn[i+1];
                if (this.horn.length == (i+1)){             //kopierar listan och minskar 1 plats, om inga fler behövs flyttas.
                    Punkt [] kopiaH = Arrays.copyOf(h,i+1);
                    this.horn = kopiaH;
                }
                else {
                    for (int j = i+1; j <= this.horn.length - 2; j++) {         //om vi behöver flytta flera punkter bak i listan minska 1 plats
                           h[j] = this.horn [j+1];
                    }
                    Punkt[] kopia2H = Arrays.copyOf(h, this.horn.length-1);
                    this.horn = kopia2H;
                }
            }
        }
    }

    public class PolylinjeIterator
    {
        private int aktuell = -1;  //aktuell fungerar som vår "pekare"
        public PolylinjeIterator () {
            if (Polylinje.this.horn.length > 0)   //om vi har hörn sätts aktuell till 0. Den kommer börja på första "noden" plats 0.
                aktuell = 0;
        }

        public boolean finnsHorn () {            //Om det finns horn är statementen true, dvs aktuell =/= -1. Om finnsHorn är falskt (dvs listan tagit slut) går aktuellt tillbaka till -1 och är utanför "listan"
            return aktuell != -1;
        }

        public Punkt horn () throws java.util.NoSuchElementException {
            if (!this.finnsHorn ())
                throw new java.util.NoSuchElementException (
                        "slut av iterationen");                     //om det inte finns horn kommer Programmet att stänga. Saknar catch?
            Punkt horn = Polylinje.this.horn[aktuell];
            return horn;                                            //Aktuell fungerar som en counter, första "loopen" är aktuellt = 0 om det finns hörn. Aktuell anger plats i listan och returnerar hörnen.
        }

        public void gaFram () {                                     //För att pekaren ska gå fram måste gaFram användas efter varje hörn returnerats. Annars returnerar den samma hörn.
            if (aktuell >= 0 &&
                    aktuell < Polylinje.this.horn.length - 1)
                aktuell++;                                          //ska köras så länge aktuell är 0- listans sista plats. Efter listans sista plats är aktuellt = -1.
            else
                aktuell = -1;
        }
    }
}
