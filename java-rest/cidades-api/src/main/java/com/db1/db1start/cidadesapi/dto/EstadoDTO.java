package com.db1.db1start.cidadesapi.dto;

import java.util.List;

public class EstadoDTO {

    private Long id;
    private String nome;

    public EstadoDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

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
}
