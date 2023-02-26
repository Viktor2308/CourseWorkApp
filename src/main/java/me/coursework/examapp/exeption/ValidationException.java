package me.coursework.examapp.exeption;

/**
 * Validation of incoming data
 */

public class ValidationException extends RuntimeException{
    public ValidationException(String entity){
        super("Validation error " + entity);
    }
}
