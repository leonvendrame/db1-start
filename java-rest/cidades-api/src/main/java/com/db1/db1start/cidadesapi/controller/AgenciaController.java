package com.db1.db1start.cidadesapi.controller;

import com.db1.db1start.cidadesapi.entity.Agencia;
import com.db1.db1start.cidadesapi.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/agencias")
public class AgenciaController {

    @Autowired
    private AgenciaService agenciaService;

    @GetMapping
    public List<Agencia> buscarTodas() {
        return agenciaService.buscarTodas();
    }

    @GetMapping("/{id}")
    public Agencia buscarPorId(@PathVariable Long id) {
        return agenciaService.buscarPorId(id);
    }
}
