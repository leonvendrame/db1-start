package com.db1.db1start.cidadesapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @OneToOne(mappedBy = "cliente")
    private Conta conta;

    public Cliente(String nome, String cpf) {
        if (nome == null) {
            throw new RuntimeException("Nome não pode ser nulo");
        } else if (cpf == null) {
            throw new RuntimeException("CPF não pode ser nulo");
        }
        this.nome = nome;
        this.cpf = cpf.replaceAll("[^0-9]", "");
    }

    public Cliente() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

}
