package com.company;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] board = new String[8][8];
        char row = 'a';
        char r = (char)(row);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = "-- ";
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

        System.out.println(sb);

    }
}

