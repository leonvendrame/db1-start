package com.db1.db1start.cidadesapi.controller;

import com.db1.db1start.cidadesapi.entity.Conta;
import com.db1.db1start.cidadesapi.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public List<Conta> buscarTodas() {
        return contaService.buscarTodas();
    }

    @GetMapping("/{id}")
    public Conta buscarPorId(@PathVariable Long id) {
        return contaService.buscarPorId(id);
    }
}
