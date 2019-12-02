package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Cliente;
import com.db1.db1start.cidadesapi.entity.Conta;
import com.db1.db1start.cidadesapi.repository.ClienteRepository;
import com.db1.db1start.cidadesapi.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ContaService contaService;

    public Cliente criar(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente atualizar(Long clienteId, String nomeNovo) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new RuntimeException("Cliente não encontrado")
        );
        cliente.setNome(nomeNovo);
        return clienteRepository.save(cliente);
    }

    public void removerPorId(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

    public void removerTodos() {
        clienteRepository.deleteAll();
    }

    public Cliente buscarPorId(Long clienteId) {
        return clienteRepository.findById(clienteId).orElseThrow(
                () -> new RuntimeException("Cliente não encontrado")
        );
    }

    public Cliente buscarPorNome(String nome) {
        return clienteRepository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Cliente não encontrado")
        );
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public void adicionarConta(Long clienteId, Conta conta) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new RuntimeException("Cliente não encontrado")
        );
        cliente.setConta(conta);
        clienteRepository.save(cliente);
    }
}
