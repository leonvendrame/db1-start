package com.db1.db1start.Operacoes;

public abstract class Operacao {
    private Integer id = 0;
    private TipoDeOperacao tipo;
    private Double valor;

    public Operacao(TipoDeOperacao tipo, Double valor) {
        this.id = ++id;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoDeOperacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeOperacao tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
