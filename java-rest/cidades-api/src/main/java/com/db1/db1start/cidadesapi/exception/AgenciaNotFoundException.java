package com.db1.db1start.cidadesapi.exception;

public class AgenciaNotFoundException extends RuntimeException {
    public AgenciaNotFoundException() {
        super("A agência não foi encontrada");
    }

    public AgenciaNotFoundException(String message) {
        super(message);
    }
}
