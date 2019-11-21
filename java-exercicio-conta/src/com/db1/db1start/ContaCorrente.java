package com.db1.db1start;

import com.db1.db1start.Excecoes.ClienteJaPossuiContaCorrente;

public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente, Double saldo) {
        super(cliente, saldo);
        if (cliente.getContaCorrente() != null) {
            throw new ClienteJaPossuiContaCorrente("O cliente já possui uma conta corrente associada");
        }
        cliente.setContaCorrente(this);
    }
}
