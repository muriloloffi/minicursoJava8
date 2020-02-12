package com.example.myorder.exception;

public class AlreadyExistsException extends RuntimeException {
    //F3 abre os métodos da classe herdada
    public AlreadyExistsException(String message) {
        super(message);
    }
}
