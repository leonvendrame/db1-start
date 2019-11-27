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

    @OneToOne(mappedBy = "conta")
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Conta(Double saldo, Agencia agencia, Cliente cliente) {
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
