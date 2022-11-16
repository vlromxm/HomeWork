package ua.romanenko.module.exception;

public class IncorrectLineReadingException extends Exception{
    public IncorrectLineReadingException (String errorMessage){
        super(errorMessage);
    }
}
