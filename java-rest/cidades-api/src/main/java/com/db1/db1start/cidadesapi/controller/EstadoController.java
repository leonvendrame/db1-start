package com.db1.db1start.cidadesapi.controller;

import com.db1.db1start.cidadesapi.adapter.EstadoAdapter;
import com.db1.db1start.cidadesapi.dto.EstadoDTO;
import com.db1.db1start.cidadesapi.entity.Estado;
import com.db1.db1start.cidadesapi.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.db1.db1start.cidadesapi.adapter.EstadoAdapter.transformaEntidadeParaDto;

@RestController
@RequestMapping("/api/v1/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<EstadoDTO> criar(@RequestBody EstadoDTO estadoDTO) {
        Estado estado = estadoService.criar(estadoDTO.getNome());
        EstadoDTO estadoResponse = transformaEntidadeParaDto(estado);
        return ResponseEntity.status(201).body(estadoResponse);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> atualizar(@PathVariable Long id, @RequestBody EstadoDTO estadoDTO) {
        Estado estado = estadoService.atualizar(id, estadoDTO.getNome());
        EstadoDTO estadoResponse = EstadoAdapter.transformaEntidadeParaDto(estado);
        return ResponseEntity.status(200).body(estadoResponse);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        estadoService.removerPorId(id);
        return ResponseEntity.status(200).build();
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<EstadoDTO>> buscarTodos() {
        List<EstadoDTO> listaDeEstados = new ArrayList<>();
        estadoService.buscarTodos().forEach(estado -> {
            listaDeEstados.add(transformaEntidadeParaDto(estado));
        });
        return ResponseEntity.status(200).body(listaDeEstados);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> buscarEstadoPorId(@PathVariable Long id) {
        Estado estado = estadoService.buscarPorId(id);
        EstadoDTO estadoResponse = transformaEntidadeParaDto(estado);
        return ResponseEntity.status(200).body(estadoResponse);
    }
}
