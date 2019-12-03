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

    @PostMapping
    public ResponseEntity<ContaDTO> criar(@RequestBody ContaDTO contaDTO) {
        try {
            Agencia agencia = agenciaService.buscarPorId(contaDTO.getAgencia().getId());
            Cliente cliente = clienteService.buscarPorId(contaDTO.getCliente().getId());
            Conta conta = contaService.criar(contaDTO.getSaldo(), agencia, cliente);
            ContaDTO contaResponse = ContaAdapter.transfomarEntidadeParaDto(conta);
            return ResponseEntity.status(200).body(contaResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaDTO> atualizar(@PathVariable Long id, @RequestBody ContaDTO contaDTO) {
        try {
            Conta conta = contaService.atualizar(id, contaDTO.getSaldo());
            ContaDTO contaResponse = ContaAdapter.transfomarEntidadeParaDto(conta);
            return ResponseEntity.status(200).body(contaResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id) {
        try {
            contaService.removerPorId(id);
            return ResponseEntity.status(200).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ContaDTO>> buscarTodas() {
        List<ContaDTO> contasReponse = new ArrayList<>();
        contaService.buscarTodas().forEach(conta -> {
            contasReponse.add(ContaAdapter.transfomarEntidadeParaDto(conta));
        });
        return ResponseEntity.status(200).body(contasReponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaDTO> buscarPorId(@PathVariable Long id) {
        try {
            Conta conta = contaService.buscarPorId(id);
            ContaDTO contaResponse = ContaAdapter.transfomarEntidadeParaDto(conta);
            return ResponseEntity.status(200).body(contaResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
