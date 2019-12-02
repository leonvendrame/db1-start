package com.db1.db1start.cidadesapi.adapter;

import com.db1.db1start.cidadesapi.dto.EstadoDTO;
import com.db1.db1start.cidadesapi.entity.Estado;

public class EstadoAdapter {

    public static EstadoDTO transformaEntidadeParaDto(Estado estado) {
        return new EstadoDTO(estado.getId(), estado.getNome());
    }
}
