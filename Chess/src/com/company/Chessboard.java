package com.company;

import java.util.Arrays;

//Schakbrädan
public class Chessboard {
    //nestlad klass
    public static class Field {
        private char row;
        private byte column;
        private Chesspiece piece = null;
        private boolean marked = false;

        //konstruktor
        public Field(char row, byte column) {
            this.row = row;
            this.column = column;
        }

        public void put(Chesspiece piece) {
            //Lägg till schackpjäsen
            this.piece = piece;
        }

        //REMOVE piece
        public Chesspiece take() {
            this.piece = null;
            return null;
        }

        public void mark() {
            this.marked = true;
        }

        public void unmark() {
            this.marked = false;
        }

        public String toString() {
            String s = (marked) ? "xx" : "--";           //If marked -> "XX", else "--"
            return (piece == null) ? s : piece.toString();
        }
    }


    //variabler som inte går att ändra på
    public static final int NUMBER_OF_ROWS = 8;
    public static final int NUMBER_OF_COLUMNS = 8;
    public static final int FIRST_ROW = 'a';          //char, kan respresenteras av en siffra a-h, 97-104  (denna rad är lika med 97)
    public static final int FIRST_COLUMN = 1;

    private Field[][] fields;           //schackbräde; vänster ska vara a-h index, höger är 1-8 index

    public Chessboard() {
        fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];     //alltid 8x8
        char row = 0;
        byte column = 0;

        for (int r = 0; r < NUMBER_OF_ROWS; r++) {      //loopen kör 8 ggr
            row = (char) (FIRST_ROW + r);               //(char) inom parantes för att casta datatypen. Row defineras som char, firstrow som int. 97+1=b, 97+2 =c, a-h
            column = FIRST_COLUMN;
            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {       //första loop; r=0 (row=a) c=0->7, dvs vi får a1, a2, a3 etc. Bygger rad för rad
                fields[r][c] = new Field(row, column);
                column++;
            }
        }
    }

    //Skriva ut brädan DUBBELKOLLA DENNA STRINGMETHOD
    public String toString() {
        String[][] board = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        StringBuilder sb = new StringBuilder();
        char row = 'a';
        char r = (char)(row);

        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                board[i][j] = "--";
            }
        }

        for( int index = 1; index <9; index++){
            sb.append("  " + index + "");
        }

        sb.append("\n");
        for (int i = 0; i < 8; i++) {
            sb.append(r++ + " ");
            for (int j = 0; j < 8; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        String chessboard = sb.toString();
        return chessboard;
    }

    // a=97, h=104 för rader, 1-8 för columnter
    public boolean isValidField (char row, byte column) {
        boolean valid;
        if ( row >= 97 && row <= 104 && column >=1 && column <=8 ) {
            valid = true;
        }
        else {
            valid = false;
        }
        return valid;
    }


    //abstrakt klass. Går inte att skapa ett objekt från klassen.
    //Subklasserna MÅSTE overridea abstrakta metoder; (för att speicifiera behaviour).
    public abstract class Chesspiece {
        private char color;
        // w - white, b - black
        private char name;
        // K - King, Q - Queen, R - Rook, B - Bishop, N - Knight,
        // P – Pawn
        protected char row = 0;                  //utanför brädan
        protected byte column = -1;             //utanför brädan

        //konstruktor??
        protected Chesspiece (char color, char name) {
            this.color = color;
            this.name = name;
        }

        public String toString () {
            return "" + color + name;
        }

        public boolean isOnBoard () {
            return Chessboard.this.isValidField (row, column);
        }

        //metod för att flytta på pjäserna, tar rad och kolumn
        public void moveTo (char row, byte column) throws NotValidFieldException {
            if (!Chessboard.this.isValidField (row, column))
                throw new NotValidFieldException ("bad field: " + row + column );
            this.row = row;
            this.column = column;
            int r = row - FIRST_ROW;                            //för att få rätt index
            int c = column - FIRST_COLUMN;                      //för att få rätt index
            Chessboard.this.fields[r][c].put (this);     // sätt pjäsen på DENNA plats i fältet
        }

        //plocka av pjäsen
        public void moveOut () {

        }

        //metoderna som måste speicificeras i subklasserna
        public abstract void markReachableFields ();
        public abstract void unmarkReachableFields ();
    }



    public class Pawn extends Chesspiece {
        public Pawn (char color, char name) {
            super (color, name);
        }       //konstruktor

        public void markReachableFields () {
            byte col = (byte) (column + 1);         //castar column från int till byte
            if (Chessboard.this.isValidField (row, col)) {      //om raden och kolumnen uppfyller isvalidField=true
                int r = row - FIRST_ROW;                        //för att få rätt index plats 1 har index 0
                int c = col - FIRST_COLUMN;                     // "-"
                Chessboard.this.fields[r][c].mark ();           //markerar
            }
        }

        public void unmarkReachableFields () {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField (row, col)) {      //isValidField metoden ligger i Chessboard klassen.
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].unmark ();
            }
        }
    }


    public class Rook extends Chesspiece {
        public Rook(char color, char name) {
            super(color, name);
        }

        public void markReachableFields() {             //kan röra sig horisontellt, rakt fram & bak. Vi vill markera flera värden, Alla på samma rad och kolumn
            byte col = (byte) (column + 1);             //sätter column till 0, castar från byte
            if (Chessboard.this.isValidField(row, column)) {
                //Vi vill markera en hel rad (konstant rad, kolumnerna 1-8)
                //Vi vill markera en hel kolumn (konstant kolumn, rad 1-8)
                int r = row - FIRST_ROW;
                int c = column - FIRST_COLUMN;

                for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
                    Chessboard.this.fields[r][i].mark();            //kommer markera hela raden r
                }

                for (int j = 0; j < FIRST_ROW; j++) {
                    Chessboard.this.fields[j][c].mark();
                    ;           //kommer markera hela kolumnen C
                }
            }
        }

        public void unmarkReachableFields() {
            byte col = (byte) (column + 1);                         //sätter column till 0, castar från byte
            if (Chessboard.this.isValidField(row, column)) {
                //Vi vill markera en hel rad (konstant rad, kolumnerna 1-8)
                //Vi vill markera en hel kolumn (konstant kolumn, rad 1-8)
                int r = row - FIRST_ROW;
                int c = column - FIRST_COLUMN;

                for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
                    Chessboard.this.fields[r][i].unmark();            //kommer avmarkera hela raden r
                }

                for (int j = 0; j < FIRST_ROW; j++) {
                    Chessboard.this.fields[j][c].unmark();
                    ;           //kommer avmarkera hela kolumnen c
                }

            }
        }

        public class Knight extends Chesspiece {
        }

        public class Bishop extends Chesspiece {
        }

        public class Queen extends Chesspiece {
        }

        public class King extends Chesspiece {
        }
    }
}

