package ua.romanenko.module.exception;

public class IncorrectLineReadingException extends RuntimeException{
    public IncorrectLineReadingException (String errorMessage){
        super(errorMessage);
    }
}
