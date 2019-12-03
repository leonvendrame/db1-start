package com.db1.db1start.cidadesapi.controller;

import com.db1.db1start.cidadesapi.adapter.AgenciaAdapter;
import com.db1.db1start.cidadesapi.dto.AgenciaDTO;
import com.db1.db1start.cidadesapi.entity.Agencia;
import com.db1.db1start.cidadesapi.entity.Cidade;
import com.db1.db1start.cidadesapi.service.AgenciaService;
import com.db1.db1start.cidadesapi.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/agencias")
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<AgenciaDTO> criar(@RequestBody AgenciaDTO agenciaDTO) {
        try {
            Cidade cidade = cidadeService.buscarPorId(agenciaDTO.getCidade().getId());
            Agencia agencia = agenciaService.criar(
                    cidade,
                    agenciaDTO.getNumeroAgencia(),
                    agenciaDTO.getNumeroBanco()
            );
            AgenciaDTO agenciaResponse = AgenciaAdapter.transformarEntidadeParaDto(agencia);
            return ResponseEntity.status(200).body(agenciaResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgenciaDTO> atualizar(@PathVariable Long id, @RequestBody AgenciaDTO agenciaDTO) {
        try {
            Agencia agencia = agenciaService.atualizar(
                    id,
                    agenciaDTO.getNumeroAgencia(),
                    agenciaDTO.getNumeroBanco()
            );
            AgenciaDTO agenciaResponse = AgenciaAdapter.transformarEntidadeParaDto(agencia);
            return ResponseEntity.status(200).body(agenciaResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id) {
        try {
            agenciaService.removerPorId(id);
            return ResponseEntity.status(200).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AgenciaDTO>> buscarTodas() {
        List<AgenciaDTO> agenciasResponse = new ArrayList<>();
        agenciaService.buscarTodas().forEach(agencia -> {
            agenciasResponse.add(AgenciaAdapter.transformarEntidadeParaDto(agencia));
        });
        return ResponseEntity.status(200).body(agenciasResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgenciaDTO> buscarPorId(@PathVariable Long id) {
        try {
            Agencia agencia = agenciaService.buscarPorId(id);
            AgenciaDTO agenciaResponse = AgenciaAdapter.transformarEntidadeParaDto(agencia);
            return ResponseEntity.status(200).body(agenciaResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }
}
