public class Polylinje{
    
    private Punkt[] horn;      //Lista skapas med "Punkt" som datatyp
    private int bredd = 1;

    public Polylinje () {

        this.horn = new Punkt[0];
    }

    public Polylinje (Punkt[] horn) {
        this.horn = new Punkt[horn.length];

        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt (horn[i]);
    }

    public String toString () {

    }

    public Punkt[] getHorn () {

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

    public double langd () {

    }

    public void laggTill (Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;
        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];
        h[i] = new Punkt (horn);
        this.horn = h;
    }

    public void laggTillFramfor (Punkt horn, String hornNamn) {

    }

    public void taBort (String hornNamn) {

    }
}
