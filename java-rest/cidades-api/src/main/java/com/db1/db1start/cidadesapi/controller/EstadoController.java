package com.db1.db1start.cidadesapi.controller;

import com.db1.db1start.cidadesapi.entity.Estado;
import com.db1.db1start.cidadesapi.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoController {

    @Autowired
    EstadoService estadoService;

    @GetMapping("/api/v1/estados/{id}")
    public Estado buscarEstadoPorId(@PathVariable Long id) {
        return estadoService.buscaPorId(id);
    }
}
