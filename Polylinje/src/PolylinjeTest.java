public class PolylinjeTest {
    public static void main(String[] args) {

        //skapar objekt från Polylinje klassen
        Polylinje punkt = new Polylinje();
        Polylinje valjPolylinje = new Polylinje();

        //Objektet (från polylinje) anropar metoden "laggTill" och skapar ett nytt objekt (från Punkt)
        //och anger argumentet som objektet Punk (och angiver argument till Punkt i sin tur
        punkt.laggTill(new Punkt("A",3, 4));
        punkt.laggTill(new Punkt ("B", 1, 2));

        //metoden lägg till framför lägger punkt C efter punkt B. Tar nya punktobjeketet som argument och namnet på
        //punkten som den kommer komma efter
        punkt.laggTillFramfor(new Punkt("C",2, 3), "B");
        System.out.println(punkt.toString());

    }
}
