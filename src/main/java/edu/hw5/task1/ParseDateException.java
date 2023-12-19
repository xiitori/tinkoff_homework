package edu.hw5.task1;

public class ParseDateException extends RuntimeException {

    public ParseDateException() {
        super("Illegal date format");
    }

}
