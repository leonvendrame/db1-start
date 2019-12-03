package com.db1.db1start.cidadesapi.exception;

public class ContaNotFoundException extends RuntimeException {
    public ContaNotFoundException() {
        super("A conta não foi encontrada");
    }

    public ContaNotFoundException(String message) {
        super(message);
    }
}
