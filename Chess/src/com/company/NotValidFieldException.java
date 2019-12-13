package com.company;

//undantagsklass extends Exception (basklassen/superklassen)
public class NotValidFieldException extends Exception {
    public NotValidFieldException(String message){                      //Konstruktor ska ta "bad field" + raden och kolumnen som argument
        super(message);                                                 //super: kallar på superklassen konstruktor, tar message som arg
    }
}
