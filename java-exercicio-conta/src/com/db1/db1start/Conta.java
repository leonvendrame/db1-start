package com.db1.db1start;

import com.db1.db1start.Excecoes.CampoNaoPodeSerNulo;
import com.db1.db1start.Excecoes.SaldoInsuficiente;
import com.db1.db1start.Excecoes.ValorNaoPodeSerMenorIgualZero;
import com.db1.db1start.Operacoes.Deposito;
import com.db1.db1start.Operacoes.Operacao;
import com.db1.db1start.Operacoes.Saque;
import com.db1.db1start.Operacoes.Tranferencia;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
    private Integer id = 0;
    private Cliente cliente;
    private Double saldo;
    private List<Operacao> operacoes;

    public Conta(Cliente cliente, Double saldo) {
        if (cliente == null) {
            throw new CampoNaoPodeSerNulo("O cliente não pode ser nulo");
        }
        this.id = ++id;
        this.cliente = cliente;
        this.saldo = saldo == null ? 0.0 : saldo;
        this.operacoes = new ArrayList<>();
    }

    public Conta(Cliente cliente) {
        if (cliente == null) {
            throw new CampoNaoPodeSerNulo("O cliente não pode ser nulo");
        }
        this.id = ++id;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.operacoes = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    protected void adicionarSaldo(Double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    protected void removerSaldo(Double valor) {
        this.setSaldo(this.getSaldo() - valor);
    }

    public void sacar(Double valor) {
        if (valor == null) {
            throw new CampoNaoPodeSerNulo("O valor de saque não pode ser nulo");
        } else if (valor <= 0) {
            throw new ValorNaoPodeSerMenorIgualZero("O valor de saque não pode ser " +
                    "menor ou igual a zero");
        } else if (valor > this.getSaldo()) {
            throw new SaldoInsuficiente("O saldo é insuficiente para realizar o saque");
        }

        getOperacoes().add(new Saque(valor));
        this.removerSaldo(valor);
    }

    public void depositar(Double valor) {
        if (valor == null) {
            throw new CampoNaoPodeSerNulo("O valor de depósito não pode ser nulo");
        } else if (valor <= 0) {
            throw new ValorNaoPodeSerMenorIgualZero("O valor de depósito não pode ser " +
                    "menor ou igual a zero");
        }

        getOperacoes().add(new Deposito(valor));
        this.adicionarSaldo(valor);
    }

    public void transferir(Double valor, ContaCorrente contaCorrenteDestino) {
        if (valor == null) {
            throw new CampoNaoPodeSerNulo("O valor de transferência não pode ser nulo");
        } else if (valor <= 0) {
            throw new ValorNaoPodeSerMenorIgualZero("O valor de transferência não pode ser " +
                    "menor ou igual a zero");
        } else if (valor > this.getSaldo()) {
            throw new SaldoInsuficiente("O saldo é insuficiente para realizar a transferência");
        }

        Tranferencia tranferencia = new Tranferencia(valor, this, contaCorrenteDestino);
        this.getOperacoes().add(tranferencia);
        contaCorrenteDestino.getOperacoes().add(tranferencia);

        this.removerSaldo(valor);
        contaCorrenteDestino.adicionarSaldo(valor);
    }

    public void extrato() {
        System.out.println("-----------EXTRATO-----------");

        this.getOperacoes().forEach(operacao -> {

            switch (operacao.getTipo()) {
                case SAQUE:
                    System.out.println(operacao.getTipo().toString() +
                            "\t\t\t-" + operacao.getValor());
                    break;
                case DEPOSITO:
                    System.out.println(operacao.getTipo().toString() +
                            "\t\t\t+" + operacao.getValor());
                    break;
                case TRANSFERENCIA:
                    System.out.println(operacao.getTipo().toString() +
                            "\t\t\t" + operacao.getValor());
            }
        });
        System.out.println("-----------------------------");
    }
}
