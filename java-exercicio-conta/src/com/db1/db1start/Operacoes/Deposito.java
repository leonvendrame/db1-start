package com.db1.db1start.Operacoes;

import com.db1.db1start.Conta;
import com.db1.db1start.Excecoes.CampoNaoPodeSerNulo;
import com.db1.db1start.Excecoes.ValorNaoPodeSerMenorIgualZero;

public class Deposito extends Operacao {

    public static void depositar(Double valor, Conta contaDestino) {
        if (valor == null) {
            throw new CampoNaoPodeSerNulo("O valor de depósito não pode ser nulo");
        } else if (valor <= 0) {
            throw new ValorNaoPodeSerMenorIgualZero("O valor de depósito não pode ser menor" +
                    "ou igual a zero");
        }

        contaDestino.depositar(valor);
    }

    public Deposito(Double valor) {
        super(TipoDeOperacao.DEPOSITO, valor);
    }
}
