package com.db1.db1start.Testes;

import com.db1.db1start.Cliente;
import com.db1.db1start.ContaCorrente;
import com.db1.db1start.Excecoes.ClienteJaPossuiContaCorrente;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ClienteTeste {

    @Test
    public void esperaCriacaoDeClientePorConstrutor() {
        Cliente cliente = new Cliente("200.400.500-32", "Teste", new Date());
        String cpfEsperado = "20040050032";
        String nomeEsperado = "Teste";
        Assert.assertEquals(cpfEsperado, cliente.getCpf());
        Assert.assertEquals(nomeEsperado, cliente.getNome());
    }

    @Test
    public void esperaExcecaoClienteJaPossuiContaCorrente() {
        Cliente cliente = new Cliente("100.200.300-59", "Teste", new Date());
        new ContaCorrente(cliente, 1000.0);
        try {
            new ContaCorrente(cliente, 100.0);
        } catch (ClienteJaPossuiContaCorrente clienteJaPossuiContaCorrente) {
            Assert.assertEquals("O cliente já possui uma conta corrente associada",
                    clienteJaPossuiContaCorrente.getMessage());
        }
    }
}
