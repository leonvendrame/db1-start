package com.db1.db1start.Excecoes;

public class CampoNaoPodeSerNulo extends RuntimeException {
    public CampoNaoPodeSerNulo(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
