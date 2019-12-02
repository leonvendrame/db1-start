package com.db1.db1start.cidadesapi.controller;

import com.db1.db1start.cidadesapi.entity.Cidade;
import com.db1.db1start.cidadesapi.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping("/api/v1/cidades")
    public List<Cidade> buscarTodas() {
        return cidadeService.buscarTodas();
    }

    @GetMapping("/api/v1/cidades/{id}")
    public Cidade buscarCidadePorId(@PathVariable Long id) {
        return cidadeService.buscarPorId(id);
    }
}
