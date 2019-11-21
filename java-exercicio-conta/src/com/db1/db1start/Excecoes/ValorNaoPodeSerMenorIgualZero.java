package com.db1.db1start.Excecoes;

public class ValorNaoPodeSerMenorIgualZero extends RuntimeException {
    public ValorNaoPodeSerMenorIgualZero(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
