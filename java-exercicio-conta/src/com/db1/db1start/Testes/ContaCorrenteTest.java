package com.db1.db1start.Testes;

import com.db1.db1start.Cliente;
import com.db1.db1start.ContaCorrente;
import com.db1.db1start.Excecoes.SaldoInsuficiente;
import com.db1.db1start.Excecoes.ValorNaoPodeSerMenorIgualZero;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class ContaCorrenteTest {

    @Test
    public void esperaCriacaoDeContaCorrentPorConstrutor() {
        Cliente clienteEsperado = new Cliente("10020044043", "Teste", new Date());
        ContaCorrente contaCorrente = new ContaCorrente(clienteEsperado, 1000.0);
        Double saldoEsperado = 1000.0;

        Assert.assertEquals(clienteEsperado, contaCorrente.getCliente());
        Assert.assertEquals(saldoEsperado, contaCorrente.getSaldo());
    }

    @Test
    public void esperaExcecaoSaldoInsuficientePorSaque() {
        Cliente cliente = new Cliente("10020044043", "Teste", new Date());
        ContaCorrente contaCorrente = new ContaCorrente(cliente, 1000.0);
        String erroEsperado = "O saldo é insuficiente para realizar o saque";
        try {
            contaCorrente.sacar(1000.01);
        } catch (SaldoInsuficiente saldoInsuficiente) {
            Assert.assertEquals(erroEsperado, saldoInsuficiente.getMessage());
        }
    }

    @Test
    public void esperaExcecaoSaldoInsuficientePorTransferencia() {
        Cliente clienteOrigem = new Cliente("10020044043", "Teste", new Date());
        Cliente clienteDestino = new Cliente("10020044044", "Teste", new Date());
        ContaCorrente contaCorrenteOrigem = new ContaCorrente(clienteOrigem, 1000.0);
        ContaCorrente contaCorrenteDestino = new ContaCorrente(clienteDestino, 1000.0);
        String erroEsperado = "O saldo é insuficiente para realizar a transferência";
        try {
            contaCorrenteOrigem.transferir(1000.01, contaCorrenteDestino);
        } catch (SaldoInsuficiente saldoInsuficiente) {
            Assert.assertEquals(erroEsperado, saldoInsuficiente.getMessage());
        }
    }

    @Test
    public void esperaExcecaoValorNaoPodeSerMenorOuIgualAZeroPorSaque() {
        Cliente cliente= new Cliente("10020044043", "Teste", new Date());
        ContaCorrente contaCorrente = new ContaCorrente(cliente, 1000.0);
        String erroEsperado = "O valor de saque não pode ser menor ou igual a zero";
        try {
            contaCorrente.sacar(0.0);
        } catch (ValorNaoPodeSerMenorIgualZero valorNaoPodeSerMenorIgualZero) {
            Assert.assertEquals(erroEsperado, valorNaoPodeSerMenorIgualZero.getMessage());
        }
    }

    @Test
    public void esperaExcecaoValorNaoPodeSerMenorOuIguaAZeroPorTransferencia() {
        Cliente clienteOrigem = new Cliente("10020044043", "Teste", new Date());
        Cliente clienteDestino = new Cliente("10020044044", "Teste", new Date());
        ContaCorrente contaCorrenteOrigem = new ContaCorrente(clienteOrigem, 1000.0);
        ContaCorrente contaCorrenteDestino = new ContaCorrente(clienteDestino, 1000.0);
        String erroEsperado = "O valor de transferência não pode ser menor ou igual a zero";
        try {
            contaCorrenteOrigem.transferir(0.0, contaCorrenteDestino);
        } catch (ValorNaoPodeSerMenorIgualZero valorNaoPodeSerMenorIgualZero) {
            Assert.assertEquals(erroEsperado, valorNaoPodeSerMenorIgualZero.getMessage());
        }
    }
}
