package com.db1.db1start;

import com.db1.db1start.Excecoes.CampoNaoPodeSerNulo;

import java.util.Date;

public class Cliente {
    private String cpf;
    private String nome;
    private Date dataDeNascimento;
    private ContaCorrente contaCorrente;

    public Cliente(String cpf, String nome, Date dataDeNascimento) {
        if (cpf == null) {
            throw new CampoNaoPodeSerNulo("O CPF não pode ser nulo");
        } else if (nome == null) {
            throw new CampoNaoPodeSerNulo("O nome não pode ser nulo");
        } else if (dataDeNascimento == null) {
            throw new CampoNaoPodeSerNulo("D data de nascimento não pode ser nula");
        }

        this.cpf = cpf.replaceAll("[^0-9]", "");
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.contaCorrente = null;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
}
