package com.db1.db1start.cidadesapi.controller;

import com.db1.db1start.cidadesapi.adapter.ClienteAdapter;
import com.db1.db1start.cidadesapi.dto.ClienteDTO;
import com.db1.db1start.cidadesapi.entity.Cliente;
import com.db1.db1start.cidadesapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> buscarTodos() {
        return clienteService.buscarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criar(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.criar(clienteDTO.getNome(),
                                                clienteDTO.getCpf());
        ClienteDTO clienteResponse = ClienteAdapter.transformaEntidadeParaDto(cliente);
        return ResponseEntity.status(200).body(clienteResponse);

    }
}
