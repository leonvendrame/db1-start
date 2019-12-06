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

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<ClienteDTO> criar(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.criar(clienteDTO.getNome(),
                clienteDTO.getCpf());
        ClienteDTO clienteResponse = ClienteAdapter.transformarEntidadeParaDto(cliente);
        return ResponseEntity.status(201).body(clienteResponse);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> alterar(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.atualizar(id, clienteDTO.getNome());
        ClienteDTO clienteResponse = ClienteAdapter.transformarEntidadeParaDto(cliente);
        return ResponseEntity.status(200).body(clienteResponse);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id) {
        clienteService.removerPorId(id);
        return ResponseEntity.status(200).build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<ClienteDTO>> buscarTodos() {
        List<ClienteDTO> clientesResponse = new ArrayList<>();
        clienteService.buscarTodos().forEach(cliente -> {
            clientesResponse.add(ClienteAdapter.transformarEntidadeParaDto(cliente));
        });
        return ResponseEntity.status(200).body(clientesResponse);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        ClienteDTO clienteResponse = ClienteAdapter.transformarEntidadeParaDto(cliente);
        return ResponseEntity.status(200).body(clienteResponse);
    }
}
