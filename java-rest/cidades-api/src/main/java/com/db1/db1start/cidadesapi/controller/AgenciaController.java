package com.db1.db1start.cidadesapi.controller;

import com.db1.db1start.cidadesapi.entity.Agencia;
import com.db1.db1start.cidadesapi.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AgenciaController {

    @Autowired
    AgenciaService agenciaService;

    @GetMapping("/api/v1/agencias")
    public List<Agencia> buscarTodas() {
        return agenciaService.buscarTodas();
    }

    @GetMapping("/api/v1/agencias/{id}")
    public Agencia buscarPorId(@PathVariable Long id) {
        return agenciaService.buscarPorId(id);
    }
}
