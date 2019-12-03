package com.db1.db1start.cidadesapi.adapter;

import com.db1.db1start.cidadesapi.dto.AgenciaDTO;
import com.db1.db1start.cidadesapi.entity.Agencia;

public class AgenciaAdapter {

    public static AgenciaDTO transformarEntidadeParaDto(Agencia agencia) {
        return new AgenciaDTO(
                agencia.getId(),
                CidadeAdapter.transformarEntidadeParaDto(agencia.getCidade()),
                agencia.getNumeroAgencia(),
                agencia.getNumeroBanco()
        );
    }
}
