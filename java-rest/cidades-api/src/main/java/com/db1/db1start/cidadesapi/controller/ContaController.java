package com.db1.db1start.cidadesapi.controller;

import com.db1.db1start.cidadesapi.adapter.ContaAdapter;
import com.db1.db1start.cidadesapi.dto.ContaDTO;
import com.db1.db1start.cidadesapi.entity.Agencia;
import com.db1.db1start.cidadesapi.entity.Cliente;
import com.db1.db1start.cidadesapi.entity.Conta;
import com.db1.db1start.cidadesapi.service.AgenciaService;
import com.db1.db1start.cidadesapi.service.ClienteService;
import com.db1.db1start.cidadesapi.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private AgenciaService agenciaService;

    @Autowired
    private ClienteService clienteService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<ContaDTO> criar(@RequestBody ContaDTO contaDTO) {
        Agencia agencia = agenciaService.buscarPorId(contaDTO.getAgencia().getId());
        Cliente cliente = clienteService.buscarPorId(contaDTO.getCliente().getId());
        Conta conta = contaService.criar(contaDTO.getSaldo(), agencia, cliente);
        ContaDTO contaResponse = ContaAdapter.transfomarEntidadeParaDto(conta);
        return ResponseEntity.status(201).body(contaResponse);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<ContaDTO> atualizar(@PathVariable Long id, @RequestBody ContaDTO contaDTO) {
        Conta conta = contaService.atualizar(id, contaDTO.getSaldo());
        ContaDTO contaResponse = ContaAdapter.transfomarEntidadeParaDto(conta);
        return ResponseEntity.status(200).body(contaResponse);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id) {
        contaService.removerPorId(id);
        return ResponseEntity.status(200).build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<ContaDTO>> buscarTodas() {
        List<ContaDTO> contasReponse = new ArrayList<>();
        contaService.buscarTodas().forEach(conta -> {
            contasReponse.add(ContaAdapter.transfomarEntidadeParaDto(conta));
        });
        return ResponseEntity.status(200).body(contasReponse);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<ContaDTO> buscarPorId(@PathVariable Long id) {
        Conta conta = contaService.buscarPorId(id);
        ContaDTO contaResponse = ContaAdapter.transfomarEntidadeParaDto(conta);
        return ResponseEntity.status(200).body(contaResponse);
    }
}
