package com.db1.db1start.cidadesapi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agencia")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    @Column
    private String numeroAgencia;

    @Column
    private String numeroBanco;

    @OneToMany(mappedBy = "agencia")
    private List<Conta> contas;

    public Agencia(Cidade cidade, String numeroAgencia, String numeroBanco) {
        if (cidade == null) {
            throw new RuntimeException("Cidade não pode ser nula");
        } else if (numeroAgencia == null) {
            throw new RuntimeException("Número da agência não pode ser nulo");
        } else if (numeroBanco == null) {
            throw new RuntimeException("Número do banco não pode ser nulo");
        }
        this.cidade = cidade;
        this.numeroAgencia = numeroAgencia.replaceAll("[^0-9]", "");
        this.numeroBanco = numeroBanco.replaceAll("[^0-9]", "");
        this.contas = new ArrayList<>();
    }

    public Agencia() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNumeroBanco() {
        return numeroBanco;
    }

    public void setNumeroBanco(String numeroBanco) {
        this.numeroBanco = numeroBanco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}
