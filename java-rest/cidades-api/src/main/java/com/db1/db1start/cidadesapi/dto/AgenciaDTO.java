package com.db1.db1start.cidadesapi.dto;

public class AgenciaDTO {

    private Long id;
    private CidadeDTO cidade;
    private String numeroAgencia;
    private String numeroBanco;

    public AgenciaDTO(Long id, CidadeDTO cidade, String numeroAgencia, String numeroBanco) {
        this.id = id;
        this.cidade = cidade;
        this.numeroAgencia = numeroAgencia;
        this.numeroBanco = numeroBanco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CidadeDTO getCidade() {
        return cidade;
    }

    public void setCidade(CidadeDTO cidade) {
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
}
