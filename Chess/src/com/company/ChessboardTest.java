package com.company;

import java.sql.SQLOutput;

public class ChessboardTest {
    public static void main(String[] args) throws NotValidFieldException {
        Chessboard chessboard = new Chessboard(); //Yttre klassen Chessboard, med ref till objtypen

        Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];  //YttreKlass.InreKlass obj lista, abstrakt inre klass, ej beroende av yttre obj.
        pieces[0] = chessboard.new Rook('w', 'R');   //obj.new Inre klass Ett objekt av inre klass beroende av yttre klass objekt => Rook en inre klass till Chessboard.
        pieces[1] = chessboard.new Queen('b', 'Q');
        pieces[2] = chessboard.new Bishop('w', 'B');
        pieces[3] = chessboard.new Pawn('b','P');
        pieces[4] = chessboard.new King('w', 'K');
        pieces[5] = chessboard.new Knight('b', 'N');

        //Testa skriva ut hur gubbarna ser ut
        System.out.println(
                "\n Rook: " + pieces[0]
                + "\n Queen: " + pieces[1]
                +" \n Bishop: "+ pieces[2]
                + "\n Pawn: " + pieces[3]
                + "\n King: " + pieces[4]
                + "\n Knight: " + pieces[5] + "\n");

        //varje ojäs har redan testats vid något tillfälle.Sammanställer allt i en loop
        for(int i = 0; i < pieces.length; i++) {
            System.out.println(pieces[i]);
            pieces[i].moveTo('d', (byte) 4);        //flytta chesspiece till plats ->
            pieces[i].markReachableFields();             //markera fälten, markerar dessa rätt?
            System.out.println(chessboard);              //Skriv ut chessoard, ska även visa spelpjäsen och markerade fält
            pieces[i].unmarkReachableFields();              //avmarkera
            pieces[i].moveOut();                            //Plocka bort pjäs
            System.out.println(chessboard);                 //Skriv ut en tom bräda (test av mveout och unmark metoder.
        }
    }
}
