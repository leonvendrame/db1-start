package com.db1.db1start.cidadesapi.exception;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException() {
        super("O cliente não foi encontrado");
    }

    public ClienteNotFoundException(String message) {
        super(message);
    }
}
