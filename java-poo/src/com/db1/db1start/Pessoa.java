package com.db1.db1start;

public abstract class Pessoa {
    private String nome;
    private String email;

    public Pessoa(String nome, String email) {
        if (nome == null) {
            throw new CampoNaoPodeSerNulo("Nome não pode ser nulo");
        }
        if (email == null) {
            throw new CampoNaoPodeSerNulo("Email não pode ser nulo");
        }
        this.nome = nome;
        this.email = email.toLowerCase();
    }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
