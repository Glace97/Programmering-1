public class Polylinje{

    //privata variabler behöver setter och getters
    private Punkt[] horn;      //Lista skapas med "Punkt" som datatyp
    private int bredd = 1;
    private String  farg= "Svart";
    private String namn;

    //initiera
    public Polylinje () {
        this.horn = new Punkt[0];
    }

    //Klassen Polylinje tar punkter som argument
    public Polylinje (Punkt[] horn) {
        this.horn = new Punkt[horn.length];      //Sätter in vad vi får som argument till längden på listan
        for (int i = 0; i < horn.length; i++)    //från 0 till sista platsen i listan, lägger vi in p1 -> pn på listan
            this.horn[i] = new Punkt (horn[i]);
    }

    //metod för att skriva ut i en fin sträng
    public String toString () {

    }

    //hämta hörnen
    public Punkt[] getHorn () {   //returnerar hörnen.
        return this.horn;
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
        double langd;
        for(int i = 0; i <this.horn.length; i++) {
            langd +=
        }
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
        Punkt[] h = new Punkt[this.horn.length+1];
        int plats = 0;

        //kopierar tidigare hörn i listan
        for(int i = 0; i <this.horn.length; i++) {
            h[i] = this.horn[i];
            if( hornNamn == h[i].getNamn() ){      //platsen ges till nya punkten
                plats = i;
                h[plats] = horn;
            }
        }
        for(int i = plats+1; i <= this.horn.length; i++) {          //flytta fram coh sätt resterande punkter i listan
            h[i] = this.horn[i-1];                    //THIS kommer ge oss gamla punkten, inet till värdet som satts om ovan
        }

        this.horn = h;   //THIS variabeln får ett nytt värde/lista.
    }

    public void taBort (String hornNamn) {

    }
}
