package com.db1.db1start.cidadesapi.controller;

import com.db1.db1start.cidadesapi.entity.Conta;
import com.db1.db1start.cidadesapi.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping("/api/v1/contas")
    public List<Conta> buscarTodas() {
        return contaService.buscarTodas();
    }

    @GetMapping("/api/v1/contas/{id}")
    public Conta buscarPorId(@PathVariable Long id) {
        return contaService.buscarPorId(id);
    }
}
