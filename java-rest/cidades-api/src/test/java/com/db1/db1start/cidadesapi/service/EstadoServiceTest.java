package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Estado;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EstadoServiceTest {

    @Autowired
    private EstadoService estadoService;

    @Test
    public void esperaEstadoCriado() {
        Estado estado = estadoService.criar("Paraná");
        Assert.assertNotNull(estado);
        System.out.println(estado.getId());
    }

    @Test
    public void esperaEstadoPorBusca() {
        Assert.assertNotNull(estadoService.buscarPorNome("Paraná"));
    }

    @Test
    public void esperaExcecaoEstadoNaoEncontrado() {
        try {
            estadoService.buscarPorNome("Paraná");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    @AfterAll
    public void limparBanco() {
        estadoService.removerTodos();
    }
}