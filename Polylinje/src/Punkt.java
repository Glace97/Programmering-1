public class Punkt {

    // initierade variabler
    String punktNamn;
    int xKordinat, yKordinat;

    //I Punkttest så testat konstruktorn genom att ge argumentet till "Punk", efter att skapad Punkt object
    // Komme också fungera som våran Setter (sätter värderna). därav "this" keyword

    public Punkt  (String namn, int x, int y) {
        this.punktNamn = namn;
        this.xKordinat = x;
        this.yKordinat = y;

    }

    //Setters för att ändra en kordinat i taget
    public void setX(int x) {
        this.xKordinat = x;
    }

    public void setY(int y) {
        this.yKordinat = y;
    }


    //Returnerar specifika värden
    public String getNamn() {
        return punktNamn;
    }

    public int getX() {
        return xKordinat;
    }

    public int getY() {
        return  yKordinat;
    }

    //räkna ut avståndet
    public double avstand(Punkt p) {
        double x = Math.abs(getX()-p.getX());
        double y = Math.abs(getY() - p.getY());
        return (Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2) ) );
    }

    public Punkt(Punkt p) {
        xKordinat = p.xKordinat;
        yKordinat = p.yKordinat;
        punktNamn = p.punktNamn;
        System.out.println(p.punktNamn + ": " +p.xKordinat + " " + p.yKordinat);
    }

    //För att skriva ut i en fin sträng
    public String toString() {
        String visa = "(" + punktNamn + ": " + xKordinat + ", " + yKordinat + ")";
        return visa;
    }
}
