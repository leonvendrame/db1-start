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

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<AgenciaDTO> criar(@RequestBody AgenciaDTO agenciaDTO) {
        Cidade cidade = cidadeService.buscarPorId(agenciaDTO.getCidade().getId());
        Agencia agencia = agenciaService.criar(
                cidade,
                agenciaDTO.getNumeroAgencia(),
                agenciaDTO.getNumeroBanco()
        );
        AgenciaDTO agenciaResponse = AgenciaAdapter.transformarEntidadeParaDto(agencia);
        return ResponseEntity.status(200).body(agenciaResponse);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<AgenciaDTO> atualizar(@PathVariable Long id, @RequestBody AgenciaDTO agenciaDTO) {
        Agencia agencia = agenciaService.atualizar(
                id,
                agenciaDTO.getNumeroAgencia(),
                agenciaDTO.getNumeroBanco()
        );
        AgenciaDTO agenciaResponse = AgenciaAdapter.transformarEntidadeParaDto(agencia);
        return ResponseEntity.status(200).body(agenciaResponse);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPorId(@PathVariable Long id) {
        agenciaService.removerPorId(id);
        return ResponseEntity.status(200).build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<AgenciaDTO>> buscarTodas() {
        List<AgenciaDTO> agenciasResponse = new ArrayList<>();
        agenciaService.buscarTodas().forEach(agencia -> {
            agenciasResponse.add(AgenciaAdapter.transformarEntidadeParaDto(agencia));
        });
        return ResponseEntity.status(200).body(agenciasResponse);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<AgenciaDTO> buscarPorId(@PathVariable Long id) {
        Agencia agencia = agenciaService.buscarPorId(id);
        AgenciaDTO agenciaResponse = AgenciaAdapter.transformarEntidadeParaDto(agencia);
        return ResponseEntity.status(200).body(agenciaResponse);
    }
}
