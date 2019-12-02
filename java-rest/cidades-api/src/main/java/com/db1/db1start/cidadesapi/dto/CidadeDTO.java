package com.db1.db1start.cidadesapi.dto;

public class CidadeDTO {

    private Long id;

    private String nome;

    private Long estadoId;

    public CidadeDTO(Long id, String nome, Long estadoId) {
        this.id = id;
        this.nome = nome;
        this.estadoId = estadoId;
    }

    public CidadeDTO() {
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

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }
}
