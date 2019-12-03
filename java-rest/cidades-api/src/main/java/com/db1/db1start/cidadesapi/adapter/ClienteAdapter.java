package com.db1.db1start.cidadesapi.adapter;

import com.db1.db1start.cidadesapi.dto.ClienteDTO;
import com.db1.db1start.cidadesapi.entity.Cliente;

public class ClienteAdapter {

    public static ClienteDTO transformarEntidadeParaDto(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getCpf());
    }
}
