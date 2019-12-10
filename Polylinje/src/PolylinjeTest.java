public class PolylinjeTest {
    public static void main(String[] args) {

        Punkt Ptest1 = new Punkt("F", 1, 2);
        Punkt[] testLista = new Punkt[]{Ptest1};

        //Går att skriva Polylinje1 om man vill testa den andra klassen med samma metoder
        //testa konstruktor
        Polylinje punkt = new Polylinje(testLista);

        // 1. (Stack) skapa address/referens punkt som pekar på null dvs oaddresserad
        // 2. (Heap) allokera en ny polylinje och ta addressen dit och stoppa in i punkt
        // new allokerar minne och ger tillbaka addressen dit  MinnesAddress new(Datatyp/Minne)

        //Objektet (från polylinje) anropar metoden "laggTill" och skapar ett nytt objekt (från Punkt)
        punkt.laggTill(new Punkt("A",3, 4));
        punkt.laggTill(new Punkt ("B", 1, 2));
        punkt.laggTill(new Punkt("C", 2, 3));
        punkt.laggTill(new Punkt("D", 5, 1));

        //Första listan av hörn
        System.out.println(punkt);

        //testa "ta bort" metoden
        punkt.taBort("F");
        System.out.println(punkt);

        //metoden lägg till framför lägger punkt C efter punkt B. Tar nya punktobjeketet som argument och namnet på
        //punkten som den kommer komma efter
        punkt.laggTillFramfor(new Punkt("C",2, 3), "B");
        System.out.println(punkt);

        //testa färgmetoden
        punkt.setFarg("Gul");
        //System.out.println(punkt.toString());
        System.out.println(punkt);

        //testa breddmetoden
        punkt.setBredd(2);
        System.out.println(punkt);

        //testa avståndsmetoden
        System.out.println(punkt.langd());

        //testa getters
        System.out.println(punkt.getFarg());
        System.out.println(punkt.getBredd());
        System.out.println(punkt.getHorn());  //kommer skriva ut en ful referens

        //Testa vår iterator.
        //PolylinjeIterator beror på Polylinje objekt.
        // YttreKlass.InreKlass inreklassRef = YtrreKlassobj.skapa inreKlass obj.
        Polylinje.PolylinjeIterator iterator = punkt.new PolylinjeIterator();
        while( iterator.finnsHorn() ) {
            System.out.println(iterator.horn());            //skriv ut hörnen
            iterator.gaFram();                              // aktuell pekare går fram. (vår next metod).
        }
    }
}
