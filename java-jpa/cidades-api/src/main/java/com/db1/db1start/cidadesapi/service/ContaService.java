package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Agencia;
import com.db1.db1start.cidadesapi.entity.Cliente;
import com.db1.db1start.cidadesapi.entity.Conta;
import com.db1.db1start.cidadesapi.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    ClienteService clienteService;

    public Conta criar(Double saldo, Agencia agencia, Cliente cliente) {
        Conta conta = new Conta(saldo, agencia, cliente);
        contaRepository.save(conta);
        clienteService.adicionarConta(conta, cliente.getId());
        return conta;
    }

    public Conta buscarPorId(Long id) {
        return contaRepository.findById(id).orElseThrow(() -> new RuntimeException("Conta não encontrada"));
    }

    public void limpar() {
        contaRepository.deleteAll();
    }

    public void removerPorId(Long id) {
        contaRepository.deleteById(id);
    }
}
