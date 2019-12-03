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

    @PostMapping
    public ResponseEntity<EstadoDTO> criar(@RequestBody EstadoDTO estadoDTO) {
        Estado estado = estadoService.criar(estadoDTO.getNome());
        EstadoDTO estadoResponse = transformaEntidadeParaDto(estado);
        return ResponseEntity.status(200).body(estadoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> atualizar(@PathVariable Long id, @RequestBody EstadoDTO estadoDTO) {
        try {
            Estado estado = estadoService.atualizar(id, estadoDTO.getNome());
            EstadoDTO estadoResponse = EstadoAdapter.transformaEntidadeParaDto(estado);
            return ResponseEntity.status(200).body(estadoResponse);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        try {
            estadoService.removerPorId(id);
            return ResponseEntity.status(200).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<EstadoDTO>> buscarTodos() {
        List<EstadoDTO> listaDeEstados = new ArrayList<>();
        estadoService.buscarTodos().forEach(estado -> {
            listaDeEstados.add(transformaEntidadeParaDto(estado));
        });
        return ResponseEntity.status(200).body(listaDeEstados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> buscarEstadoPorId(@PathVariable Long id) {
        EstadoDTO estadoResponse = transformaEntidadeParaDto(
                estadoService.buscarPorId(id)
        );
        return ResponseEntity.status(200).body(estadoResponse);
    }
}
