package com.db1.db1start.cidadesapi.adapter;

import com.db1.db1start.cidadesapi.dto.ContaDTO;
import com.db1.db1start.cidadesapi.entity.Conta;

public class ContaAdapter {

    public static ContaDTO transfomarEntidadeParaDto(Conta conta) {
        return new ContaDTO(
                conta.getId(),
                conta.getSaldo(),
                AgenciaAdapter.transformarEntidadeParaDto(conta.getAgencia()),
                ClienteAdapter.transformarEntidadeParaDto(conta.getCliente())
        );
    }
}
