package com.db1.db1start.cidadesapi.entity;

import javax.persistence.*;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "agencia_id")
    private Agencia agencia;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Conta(Double saldo, Agencia agencia, Cliente cliente) {
        if (saldo == null) {
            throw new RuntimeException("Saldo não pode ser nulo");
        } else if (agencia == null) {
            throw new RuntimeException("Agência não pode ser nula");
        } else if (cliente ==null) {
            throw new RuntimeException("Cliente não pode ser nulo");
        }
        this.saldo = saldo;
        this.agencia = agencia;
        this.cliente = cliente;
    }

    public Conta() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
