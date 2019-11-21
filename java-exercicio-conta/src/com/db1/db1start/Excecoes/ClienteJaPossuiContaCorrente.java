package com.db1.db1start.Excecoes;

public class ClienteJaPossuiContaCorrente extends RuntimeException {
    public ClienteJaPossuiContaCorrente(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
