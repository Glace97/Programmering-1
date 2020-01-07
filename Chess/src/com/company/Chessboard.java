package com.company;

import javax.xml.namespace.QName;
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
        public Chesspiece removePiece() {
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
//Slutet på fieldklassen

    //variabler som inte går att ändra på
    public static final int NUMBER_OF_ROWS = 8;
    public static final int NUMBER_OF_COLUMNS = 8;
    public static final int FIRST_ROW = 'a';          //char, kan respresenteras av en siffra a-h, 97-104  (denna rad är lika med 97)
    public static final int FIRST_COLUMN = 1;

    private Field[][] fields;           //schackbräde; vänster ska vara a-h index, höger är 1-8 index

    //konstruktor
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


    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("    1  2  3  4  5  6  7  8\n");
        for(int i = 0; i < 8; i++)
        {
            sb.append((char) (i + FIRST_ROW) + " ");
            for(int i2 = 0; i2 < 8; i2++)
            {
                sb.append(" " + fields[i][i2]);
                if(i2 == 7)
                {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();
    }

    // a=97, h=104 för rader, 1-8 för columnter
    public boolean isValidField(char row, byte column) {
        boolean valid;
        if (row >= 97 && row <= 104 && column >= 1 && column <= 8) {
            valid = true;
        } else {
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
        protected Chesspiece(char color, char name) {
            this.color = color;
            this.name = name;
        }

        public String toString() {
            return "" + color + name;
        }

        //kollar om schakpjäsen är på brädan
        public boolean isOnBoard() {
            return Chessboard.this.isValidField(row, column);
        }

        //metod för att flytta på pjäserna, tar rad och kolumn
        public void moveTo(char row, byte column) throws NotValidFieldException {
            if (!Chessboard.this.isValidField(row, column))
                throw new NotValidFieldException("bad field: " + row + column);
            this.row = row;
            this.column = column;
            int r = row - FIRST_ROW;                            //för att få rätt index
            int c = column - FIRST_COLUMN;                      //för att få rätt index
            Chessboard.this.fields[r][c].put(this);     // sätt pjäsen på DENNA plats i fältet
        }

        //plocka av pjäsen
        public void moveOut() {
            if (isOnBoard()) {
                Chessboard.this.fields[row - FIRST_ROW][column - FIRST_COLUMN].removePiece();
            }
        }

        //metoderna som måste speicificeras i subklasserna
        public abstract void markReachableFields();

        public abstract void unmarkReachableFields();
    }


    public class Pawn extends Chesspiece {
        public Pawn(char color, char name) {
            super(color, name);
        }       //konstruktor

        public void markReachableFields() {
            byte col = (byte) (column + 1);         //castar column från int till byte
            if (Chessboard.this.isValidField(row, col)) {      //om raden och kolumnen uppfyller isvalidField=true
                int r = row - FIRST_ROW;                        //för att få rätt index plats 1 har index 0
                int c = col - FIRST_COLUMN;                     // "-"
                Chessboard.this.fields[r][c].mark();           //markerar
            }
        }

        public void unmarkReachableFields() {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {      //isValidField metoden ligger i Chessboard klassen.
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].unmark();
            }
        }
    }


    //if this is valid field-> tar hänsyn till om det står andra spelare i vägen
    public class Rook extends Chesspiece {
        public Rook(char color, char name) {
            super(color, name);
        }

        @Override
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

                for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                    Chessboard.this.fields[j][c].mark();
                    ;           //kommer markera hela kolumnen C
                }
            }
        }

        @Override
        public void unmarkReachableFields() {
            byte col = (byte) (column + 1);                         //sätter column till 0, castar från byte
            if (Chessboard.this.isValidField(row, column)) {
                //Vi vill avmarkera en hel rad (konstant rad, kolumnerna 1-8)
                //Vi vill avmarkera en hel kolumn (konstant kolumn, rad 1-8)
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
    }

    public class Knight extends Chesspiece {
        //Konstruktor
        public Knight(char color, char name) {
            super(color, name);
        }

        byte col = (byte) (column + 1);

        @Override
        public void markReachableFields() {
            if ((Chessboard.this.isValidField(row, column))) {
                int r = row - FIRST_ROW;
                int c = column - FIRST_COLUMN;
                int stepsForward = 0;
                //Riddaren kan gå 2 steg fram och ett till höger

                while (stepsForward < 2) {
                    if (r + stepsForward + 1 < NUMBER_OF_ROWS) {
                        Chessboard.this.fields[r + stepsForward + 1][c].mark(); //markera 2 stegen framför
                    }
                    if (0 <= r - stepsForward - 1) {
                        Chessboard.this.fields[r - stepsForward - 1][c].mark(); //markera 2 stegen framför
                    }
                    stepsForward++;
                }
                if(r + stepsForward < NUMBER_OF_ROWS) {
                    if(c + 1 < NUMBER_OF_COLUMNS) {
                        Chessboard.this.fields[r + stepsForward][c + 1].mark(); //markera det högra steget
                    }
                    if(0 <= c - 1) {
                        Chessboard.this.fields[r + stepsForward][c - 1].mark();
                    }
                }
                if(0 <= r - stepsForward) {
                    if(c + 1 < NUMBER_OF_COLUMNS) {
                        Chessboard.this.fields[r - stepsForward][c + 1].mark(); //markera det högra steget
                    }
                    if(0 <= c - 1) {
                        Chessboard.this.fields[r - stepsForward][c - 1].mark();
                    }
                }
            }
        }

        @Override
        public void unmarkReachableFields() {
            if ((Chessboard.this.isValidField(row, column))) {
                int r = row - FIRST_ROW;
                int c = column - FIRST_COLUMN;
                int stepsForward = 0;
                //Riddaren kan gå 2 steg fram och ett till höger

                while (stepsForward < 2) {
                    Chessboard.this.fields[++r][c].unmark(); //markera 2 stegen framför
                    stepsForward++;
                }
                Chessboard.this.fields[r][c++].unmark(); //markera det högra steget
            }
        }
    }


        public class Bishop extends Chesspiece {
            //konstruktor
            public Bishop (char color, char name) {
                super(color, name);
            }

            byte col = (byte) (column + 1);
            //Kan röra sig diagonalt och slå bort spelare i sin väg.

            @Override
            public void markReachableFields() {
                if (Chessboard.this.isValidField(row, column)) {
                    int r = row - FIRST_ROW;
                    int c = column - FIRST_COLUMN;

                    int forwardR = 0;
                    int forwardL = 0;
                    int backR = 0;
                    int backL = 0;

                    //frammåt, höger diagonal
                    while ((r - forwardR) >= 0 && (c + forwardR) <= 7) {
                        Chessboard.this.fields[r - forwardR][c + forwardR].mark();
                        forwardR++;
                    }

                    //frammåt vänster, diagonal
                    while ((r - forwardL) >= 0 && (c - forwardL) >= 0) {
                        Chessboard.this.fields[r - forwardL][c - forwardL].mark();
                        forwardL++;
                    }

                    //bakåt höger, diagonal
                    while ((r + backR) <= 7 && (c + backR) <= 7) {
                        Chessboard.this.fields[r + backR][c + backR].mark();
                        backR++;
                    }

                    //bakåt, vänster
                    while ((r + backL) <= 7 && (c - backL) >= 0) {
                        Chessboard.this.fields[r + backL][c - backL].mark();
                        backL++;
                    }
                }
            }

            @Override
            public void unmarkReachableFields(){
                if(Chessboard.this.isValidField(row, column)) {
                    int r = row - FIRST_ROW;
                    int c = column - FIRST_COLUMN;

                    int forwardR = 0;
                    int forwardL = 0;
                    int backR = 0;
                    int backL = 0;

                    //frammåt, höger diagonal
                    while( (r-forwardR) >= 0 && (c+forwardR)<= 7 ) {
                        Chessboard.this.fields[r-forwardR][c+forwardR].unmark();
                        forwardR++;
                    }

                    //frammåt vänster, diagonal
                    while( (r-forwardL) >= 0 && (c-forwardL) >= 0 ) {
                        Chessboard.this.fields[r-forwardL][c-forwardL].unmark();
                        forwardL++;
                    }

                    //bakåt höger, diagonal
                    while((r+backR) <= 7 && (c+backR) <= 7) {
                        Chessboard.this.fields[r+backR][c+backR].unmark();
                        backR++;
                    }

                    //bakåt, vänster
                    while( (r+backL) <= 7 && (c-backL) >= 0) {
                        Chessboard.this.fields[r+backL][c-backL].unmark();
                        backL++;
                    }

                }
            }
        }

        public class Queen extends Chesspiece {

            public Queen(char color, char name) {
                super(color, name);
            }

            byte col = (byte) (column + 1);

            @Override
            public void markReachableFields() {
                if (Chessboard.this.isValidField(row, column)) {
                    int r = row - FIRST_ROW;
                    int c = column - FIRST_COLUMN;

                    int forwardR = 0;
                    int forwardL = 0;
                    int backR = 0;
                    int backL = 0;

                    //frammåt, höger diagonal
                    while ((r - forwardR) >= 0 && (c + forwardR) <= 7) {
                        Chessboard.this.fields[r - forwardR][c + forwardR].mark();
                        forwardR++;
                    }

                    //frammåt vänster, diagonal
                    while ((r - forwardL) >= 0 && (c - forwardL) >= 0) {
                        Chessboard.this.fields[r - forwardL][c - forwardL].mark();
                        forwardL++;
                    }

                    //bakåt höger, diagonal
                    while ((r + backR) <= 7 && (c + backR) <= 7) {
                        Chessboard.this.fields[r + backR][c + backR].mark();
                        backR++;
                    }

                    //bakåt, vänster
                    while ((r + backL) <= 7 && (c - backL) >= 0) {
                        Chessboard.this.fields[r + backL][c - backL].mark();
                        backL++;
                    }

                    //Frammåt och bakåt
                    for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
                        Chessboard.this.fields[r][i].mark();            //kommer markera hela raden r
                    }

                    for (int j = 0; j < NUMBER_OF_ROWS; j++) {
                        Chessboard.this.fields[j][c].mark();             //kommer markera hela kolumnen c

                    }
                }
            }

            public void unmarkReachableFields() {
                if (Chessboard.this.isValidField(row, column)) {
                    int r = row - FIRST_ROW;
                    int c = column - FIRST_COLUMN;

                    int forwardR = 0;
                    int forwardL = 0;
                    int backR = 0;
                    int backL = 0;

                    //frammåt, höger diagonal
                    while ((r - forwardR) >= 0 && (c + forwardR) <= 7) {
                        Chessboard.this.fields[r - forwardR][c + forwardR].unmark();
                        forwardR++;
                    }

                    //frammåt vänster, diagonal
                    while ((r - forwardL) >= 0 && (c - forwardL) >= 0) {
                        Chessboard.this.fields[r - forwardL][c - forwardL].unmark();
                        forwardL++;
                    }

                    //bakåt höger, diagonal
                    while ((r + backR) <= 7 && (c + backR) <= 7) {
                        Chessboard.this.fields[r + backR][c + backR].unmark();
                        backR++;
                    }

                    //bakåt, vänster
                    while ((r + backL) <= 7 && (c - backL) >= 0) {
                        Chessboard.this.fields[r + backL][c - backL].unmark();
                        backL++;
                    }

                    //Frammåt och bakåt
                    for (int i = 0; i < NUMBER_OF_COLUMNS; i++) {
                        Chessboard.this.fields[r][i].unmark();            //kommer markera hela raden r
                    }

                    for (int j = 0; j < FIRST_ROW; j++) {
                        Chessboard.this.fields[j][c].unmark();             //kommer markera hela kolumnen c

                    }
                }
            }
        }

        public class King extends Chesspiece {

                public King (char color, char name) {
                super(color, name);
            }

            public void markReachableFields() {
              //  byte col = (byte) (column + 1);

                if (Chessboard.this.isValidField(row, column)){
                    int rIndex = row - FIRST_ROW;
                    int cIndex = column - FIRST_COLUMN;
                    for (int row = rIndex - 1; row <= rIndex + 1; row++) {
                        if(0 <= row && row < 8) {
                            for(int col = cIndex - 1; col <= cIndex + 1; col++) {
                                if(0 <= col && col < 8)
                                    Chessboard.this.fields[row][col].mark();
                            }
                        }
                    }
                }

            }

            public void unmarkReachableFields() {
                byte col = (byte) (column + 1);

                if (Chessboard.this.isValidField(row, column)){
                    int r = row - FIRST_ROW;
                    int c = column - FIRST_COLUMN;

                    //markera framför
                    if( r-1 >= 0 ) {
                        Chessboard.this.fields[r - 1][c].unmark();
                    }

                    //markera bakom
                    if( r+1 <= 7 ){
                        Chessboard.this.fields[r+1][c].unmark();
                    }

                    //markera till höger
                    if ( c+1 <= 7 ) {
                        Chessboard.this.fields[r][c+1].unmark();
                    }

                    //markera till vänster
                    if( c-1 >= 0 ){
                        Chessboard.this.fields[r][c-1].unmark();
                    }

                    //markera höger diagonal fram
                    if(c+1 <= 7 && r-1 >= 0 ){
                        Chessboard.this.fields[r-1][c+1].unmark();
                    }

                    //markera vänster diagonal fram
                    if( c-1 >= 0 && r-1 >= 0 ) {
                        Chessboard.this.fields[r-1][c-1].unmark();
                    }

                    //markera höger diagonal bak
                    if ( r+1 <= 7 && c+1 <= 7 ){
                        Chessboard.this.fields[r+1][c+1].unmark();
                    }

                    //markera vänstra diagonalen bak
                    if ( r-1 >= 0 && c-1 >= 0){
                        Chessboard.this.fields[r-1][c-1].unmark();
                    }

                }
            }
        }
}



