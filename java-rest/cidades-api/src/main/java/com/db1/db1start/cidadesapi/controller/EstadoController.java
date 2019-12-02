package com.db1.db1start.cidadesapi.controller;

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

    @PostMapping
    public ResponseEntity<EstadoDTO> criarEstado(EstadoDTO estadoDTO) {
        EstadoDTO estadoResponse = transformaEntidadeParaDto(
                estadoService.criar(estadoDTO.getNome())
        );
        return ResponseEntity.status(200).body(estadoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        estadoService.removerPorId(id);
        return ResponseEntity.noContent().build();
    }
}
