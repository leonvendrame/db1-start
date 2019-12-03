package com.db1.db1start.cidadesapi.dto;

public class ContaDTO {

    private Long id;
    private Double saldo;
    private AgenciaDTO agencia;
    private ClienteDTO cliente;

    public ContaDTO(Long id, Double saldo, AgenciaDTO agencia, ClienteDTO cliente) {
        this.id = id;
        this.saldo = saldo;
        this.agencia = agencia;
        this.cliente = cliente;
    }

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

    public AgenciaDTO getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaDTO agencia) {
        this.agencia = agencia;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }
}
