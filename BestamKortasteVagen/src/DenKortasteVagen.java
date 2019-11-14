public class DenKortasteVagen {

    // langd returnerar längden av den kortaste vägen.
    public static double langd (double[] a, double[][] b, double[] c) {  //B är en matris eftersom det finns flera möjliga vägar mellan U och VkortastLangd = a[0] + b[0][0] + c[0];

        double kortastLangd = a[0] + b[0][0] + c[0];

        for (int j = 0; j < c.length; j++) {              //loopen körs från 0-> c.length, antalet vägar från V-> Y
            for (int i = 0; i < a.length; i++) {               //loopen körs från 0-> a.length, antalet vägar från X till U
                if (kortastLangd > a[i] + b[i][j] + c[j]) {
                    kortastLangd = a[i] + b[i][j] + c[j];
                }
            }
        }
        return kortastLangd;
    }

    // mellanstationer returnerar en vektor med de mellanstationer som finns på den kortaste
    // vägen. Ordningsnummer av den första mellanstationen finns på index 1, och ordningsnummer
    // av den andra mellanstationen på index 2 i vektorn.
    public static int[] mellanstationer (double[] a, double[][] b, double[] c) {

        double kortastLangd = a[0] + b[0][0] + c[0];
        int stationU = 1;
        int stationV = 1;

        for (int j = 0; j < c.length; j++) {              //loopen körs från 1-> c.length,
            for (int i = 0; i < a.length; i++) {             //loopen körs från 1-> a.length. Byter dessa loopar plats körs ejj alla värden igenom och vi får inte ut kortaste sträckan.

                if (kortastLangd > a[i] + b[i][j] + c[j]) {
                    kortastLangd = a[i] + b[i][j] + c[j];
                    stationU=i+1;   //+1 eftersom jag vill att stationsiffran börjar på 1,  1<=i<=m.
                    stationV=j+1;   //  -"-
                }
            }
        }

        int antalZoner = 4;  //hårdkordat, det är alltid 4 zoner i upptgiften oavsett input
        int mellanstationer[] = new int[antalZoner];
        mellanstationer[1] = stationU; //assign värdet
        mellanstationer[2] = stationV; //assign värdet
        return mellanstationer;

    }
}
