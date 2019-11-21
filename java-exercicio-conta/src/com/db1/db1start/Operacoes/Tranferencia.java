package com.db1.db1start.Operacoes;
import com.db1.db1start.*;

public class Tranferencia extends Operacao {
    private Conta contaOrigem;
    private Conta contaDestino;

    public Tranferencia(Double valor, Conta contaOrigem, Conta contaCorrenteDestino) {
        super(TipoDeOperacao.TRANSFERENCIA, valor);
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaCorrenteDestino;
    }

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }
}
