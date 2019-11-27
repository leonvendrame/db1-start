package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Conta;
import com.db1.db1start.cidadesapi.entity.Estado;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContaServiceTest {

    @Autowired
    ContaService contaService;

    @Autowired
    AgenciaService agenciaService;

    @Autowired
    CidadeService cidadeService;

    @Autowired
    EstadoService estadoService;

    @Autowired
    ClienteService clienteService;


    @Test
    public void esperaContaCriada() {
        estadoService.criar("São Paulo");
        cidadeService.criar("Osasco", estadoService.buscaEstadoPorNome("São Paulo"));
        agenciaService.criar(cidadeService.buscaCidadePorNome("Osasco"), "0001", "0001");
        clienteService.criar("Leonardo", "000000000");
        Conta conta = contaService.criar(0d, agenciaService.buscarPorNumeroAgencia("0001"),
                clienteService.buscarPorNome("Leonardo"));

        Assert.assertNotNull(contaService.buscarPorId(conta.getId()));
    }

}