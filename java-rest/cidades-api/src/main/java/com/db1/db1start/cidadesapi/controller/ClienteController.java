package com.db1.db1start.cidadesapi.controller;

import com.db1.db1start.cidadesapi.adapter.ClienteAdapter;
import com.db1.db1start.cidadesapi.dto.ClienteDTO;
import com.db1.db1start.cidadesapi.entity.Cliente;
import com.db1.db1start.cidadesapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO> criar(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.criar(clienteDTO.getNome(),
                clienteDTO.getCpf());
        ClienteDTO clienteResponse = ClienteAdapter.transformarEntidadeParaDto(cliente);
        return ResponseEntity.status(200).body(clienteResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> alterar(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente;
        try {
            cliente = clienteService.atualizar(clienteDTO.getId(), clienteDTO.getNome());
            ClienteDTO clienteResponse = ClienteAdapter.transformarEntidadeParaDto(cliente);
            return ResponseEntity.status(200).body(clienteResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id) {
        try {
            clienteService.removerPorId(id);
            return ResponseEntity.status(200).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarTodos() {
        List<ClienteDTO> clientesResponse = new ArrayList<>();
        clienteService.buscarTodos().forEach(cliente -> {
            clientesResponse.add(ClienteAdapter.transformarEntidadeParaDto(cliente));
        });
        return ResponseEntity.status(200).body(clientesResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id) {
        Cliente cliente;
        ClienteDTO clienteResponse;
        try {
            cliente = clienteService.buscarPorId(id);
            clienteResponse = ClienteAdapter.transformarEntidadeParaDto(cliente);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(clienteResponse);
    }
}
