package com.db1.db1start.cidadesapi.dto;

public class CidadeDTO {

    private Long id;

    private String nome;

    private EstadoDTO estado;

    public CidadeDTO(Long id, String nome, EstadoDTO estadoDTO) {
        this.id = id;
        this.nome = nome;
        this.estado = estadoDTO;
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

    public EstadoDTO getEstado() {
        return estado;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }
}
