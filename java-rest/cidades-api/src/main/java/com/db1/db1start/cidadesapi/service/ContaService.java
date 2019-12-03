package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Agencia;
import com.db1.db1start.cidadesapi.entity.Cliente;
import com.db1.db1start.cidadesapi.entity.Conta;
import com.db1.db1start.cidadesapi.exception.ContaNotFoundException;
import com.db1.db1start.cidadesapi.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private ClienteService clienteService;

    public Conta criar(Double saldo, Agencia agencia, Cliente cliente) {
        Conta conta = new Conta(saldo, agencia, cliente);
        contaRepository.save(conta);
        return conta;
    }

    public Conta atualizar(Long contaId, Double saldoNovo) {
        Conta conta = buscarPorId(contaId);
        conta.setSaldo(saldoNovo);
        return contaRepository.save(conta);
    }

    public Conta atualizarPorClienteId(Long clienteId, Double saldoNovo) {
        Conta conta = buscarPorClienteId(clienteId);
        conta.setSaldo(saldoNovo);
        return contaRepository.save(conta);
    }

    public void removerPorId(Long contaId) {
        contaRepository.deleteById(contaId);
    }

    public void removerTodos() {
        contaRepository.deleteAll();
    }

    public Conta buscarPorId(Long contaId) {
        Conta conta = contaRepository.findById(contaId).orElseThrow(
                ContaNotFoundException::new
        );
        return conta;
    }

    public Conta buscarPorClienteId(Long id) {
        return contaRepository.findByCliente(clienteService.buscarPorId(id)).orElseThrow(
                ContaNotFoundException::new
        );
    }

    public List<Conta> buscarTodas() {
        return contaRepository.findAll();
    }

    public void adicionarCliente(Long contaId, Cliente cliente) {
        Conta conta = contaRepository.findById(contaId).orElseThrow(
                () -> new RuntimeException("Conta não encontrada")
        );
        conta.setCliente(cliente);
        contaRepository.save(conta);
    }
}
