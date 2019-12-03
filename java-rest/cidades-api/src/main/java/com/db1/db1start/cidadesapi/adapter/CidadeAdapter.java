package com.db1.db1start.cidadesapi.adapter;

import com.db1.db1start.cidadesapi.dto.CidadeDTO;
import com.db1.db1start.cidadesapi.entity.Cidade;

public class CidadeAdapter {

    public static CidadeDTO transformarEntidadeParaDto(Cidade cidade) {
        return new CidadeDTO(
                cidade.getId(),
                cidade.getNome(),
                EstadoAdapter.transformaEntidadeParaDto(cidade.getUf())
        );
    }
}
