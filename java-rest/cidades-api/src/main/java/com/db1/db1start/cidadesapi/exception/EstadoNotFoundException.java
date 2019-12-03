package com.db1.db1start.cidadesapi.exception;

public class EstadoNotFoundException extends RuntimeException {
    public EstadoNotFoundException() {
        super("O estado não foi encontrado");
    }

    public EstadoNotFoundException(String message) {
        super(message);
    }
}
