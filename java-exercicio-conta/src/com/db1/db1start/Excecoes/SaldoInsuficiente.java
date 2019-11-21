package com.db1.db1start.Excecoes;

public class SaldoInsuficiente extends RuntimeException {
    public SaldoInsuficiente(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
