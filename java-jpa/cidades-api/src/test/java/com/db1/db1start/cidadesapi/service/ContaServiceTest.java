package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Cliente;
import com.db1.db1start.cidadesapi.entity.Conta;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Before
    public void limparBanco() {
        contaService.limpar();
        clienteService.limpar();
        agenciaService.limpar();
        cidadeService.limpar();
        estadoService.limpar();
    }

    @Test
    public void esperaContaCriada() {
        estadoService.criar("Paraná");
        cidadeService.criar("Marialva", estadoService.buscaEstadoPorNome("Paraná"));
        agenciaService.criar(cidadeService.buscaCidadePorNome("Marialva"), "0001", "0001");
        Cliente cliente = clienteService.criar("Leonardo", "000000000");
        Conta conta = contaService.criar(0d, agenciaService.buscarPorNumeroAgencia("0001"), cliente);

        Assert.assertNotNull(contaService.buscarPorId(conta.getId()));
    }

    @Test
    public void esperaEncontrarContaPorIdCliente() {
        estadoService.criar("Paraná");
        cidadeService.criar("Marialva", estadoService.buscaEstadoPorNome("Paraná"));
        agenciaService.criar(cidadeService.buscaCidadePorNome("Marialva"), "0001", "0001");
        Cliente cliente = clienteService.criar("Leonardo", "000000000");
        Conta contaEsperada = contaService.criar(200d, agenciaService.buscarPorNumeroAgencia("0001"), cliente);

        Conta conta = contaService.buscarPorIdCliente(cliente.getId());
        Assert.assertEquals(contaEsperada.getId(), conta.getId());
        Assert.assertEquals(contaEsperada.getAgencia().getId(), conta.getAgencia().getId());
        Assert.assertEquals(contaEsperada.getCliente().getId(), conta.getCliente().getId());
        Assert.assertEquals(contaEsperada.getSaldo(), conta.getSaldo());
    }
}