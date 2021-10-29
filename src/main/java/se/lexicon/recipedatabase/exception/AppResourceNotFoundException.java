package se.lexicon.recipedatabase.exception;

public class AppResourceNotFoundException extends IllegalArgumentException{
    public AppResourceNotFoundException(String message) {
        super(message);
    }
}

