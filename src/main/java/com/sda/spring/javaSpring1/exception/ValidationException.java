package com.sda.spring.javaSpring1.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(String message){
        super(message);
    }
}
