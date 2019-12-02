package com.db1.db1start.cidadesapi.dto;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;

    public ClienteDTO(Long id,String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
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
}
