package com.db1.db1start.cidadesapi.controller;

import com.db1.db1start.cidadesapi.adapter.CidadeAdapter;
import com.db1.db1start.cidadesapi.adapter.EstadoAdapter;
import com.db1.db1start.cidadesapi.dto.CidadeDTO;
import com.db1.db1start.cidadesapi.entity.Cidade;
import com.db1.db1start.cidadesapi.entity.Estado;
import com.db1.db1start.cidadesapi.service.CidadeService;
import com.db1.db1start.cidadesapi.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<CidadeDTO> criar(@RequestBody CidadeDTO cidadeDTO) {
        Estado estado = estadoService.buscarPorId(cidadeDTO.getEstado().getId());
        Cidade cidade = cidadeService.criar(cidadeDTO.getNome(), estado);
        CidadeDTO cidadeResponse = CidadeAdapter.transformarEntidadeParaDto(cidade);
        return ResponseEntity.status(201).body(cidadeResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CidadeDTO> atualizar(@PathVariable Long id, @RequestBody CidadeDTO cidadeDTO) {
        Cidade cidade = cidadeService.atualizar(id, cidadeDTO.getNome());
        CidadeDTO cidadeResponse = CidadeAdapter.transformarEntidadeParaDto(cidade);
        return ResponseEntity.status(200).body(cidadeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id) {
        cidadeService.removerPorId(id);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<List<CidadeDTO>> buscarTodas() {
        List<CidadeDTO> cidadesResponse = new ArrayList<>();
        cidadeService.buscarTodas().forEach(cidade -> {
            cidadesResponse.add(CidadeAdapter.transformarEntidadeParaDto(cidade));
        });
        return ResponseEntity.status(200).body(cidadesResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CidadeDTO> buscarCidadePorId(@PathVariable Long id) {
        Cidade cidade = cidadeService.buscarPorId(id);
        CidadeDTO cidadeResponse = CidadeAdapter.transformarEntidadeParaDto(cidade);
        return ResponseEntity.status(200).body(cidadeResponse);
    }
}
