import java.util.Scanner;

public class Triangel {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Vad ska räknas ut?" + "\n" + "1.Omkrets" + "\n" + "2.Area" + "\n" + "3.Medianen");
        int val = input.nextInt();
        switch (val){
            case 1:
                System.out.println("Skriv längden på sidorna till triangeln. Summorna av de två första sidorna -måste- vara längre än den tredje.");
                double x = input.nextDouble();
                double y = input.nextDouble();
                double z = input.nextDouble();
                if((x+y)<z || x<=0 || y<=0 || z<=0){
                    System.out.println("Ogiltigt");
                }else{
                    System.out.println(triangelnsOmkrets(x,y,z));
                }
                break;
            case 2:
                System.out.println("Skriv basen och höjden");
                double b = input.nextDouble();
                double h = input.nextDouble();
                if( b<=0 || h<=0){
                    System.out.println("Ogiltigt");
                }else{
                    System.out.println(triangelnsArea(b,h));
                }
                break;
        }
    }
    //metod för att räkna omkrets
    static double triangelnsOmkrets(double x, double y, double z){
        double omkrets=x+y+z;
        return omkrets;
    }
    static double triangelnsArea(double b, double h){
        double area = (b*h)/2;
        return area;
    }
}
