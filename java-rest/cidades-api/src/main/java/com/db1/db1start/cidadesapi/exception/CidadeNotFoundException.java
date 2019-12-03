package com.db1.db1start.cidadesapi.exception;

public class CidadeNotFoundException extends RuntimeException {
    public CidadeNotFoundException() {
        super("A cidade não foi econtrada");
    }

    public CidadeNotFoundException(String message) {
        super(message);
    }
}
