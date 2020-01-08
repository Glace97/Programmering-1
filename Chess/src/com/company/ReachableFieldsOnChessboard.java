package com.company;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ReachableFieldsOnChessboard {
    public static void main(String[] args) throws InterruptedException, NotValidFieldException {
        Chessboard chessBoard = new Chessboard();
        Chessboard.Chesspiece[] pieces = new Chessboard.Chesspiece[6];
        System.out.println (chessBoard + "\n");

        pieces[0] = chessBoard.new Pawn('w', 'P');
        pieces[1] = chessBoard.new Rook('b', 'R');
        pieces[2] = chessBoard.new Queen('w', 'Q');
        pieces[3] = chessBoard.new Bishop('w', 'B');
        pieces[4] = chessBoard.new King('b', 'K');
        pieces[5] = chessBoard.new Knight('w', 'N');

        Random random = new Random();
        char randomChar = (char) (97 + random.nextInt(8));
        byte randomByte = (byte) (1+ random.nextInt(8));


        for (int i = 0; i< pieces.length; i++){                     //loopen kör igenom alla gubbar
                TimeUnit.SECONDS.sleep(5);                 // loppen "vilar efter den är nollad sen tidigare"
                pieces[i].moveTo(randomChar, randomByte);           // Slumpad plats
                pieces[i].markReachableFields();                    //markerar
                System.out.println (chessBoard + "\n");             //skriver ut bräden

                TimeUnit.SECONDS.sleep(5);                  //Brädan visas i 3 sek
                pieces[i].moveOut();
                pieces[i].unmarkReachableFields();
                System.out.println(chessBoard);
            }
        }
}
