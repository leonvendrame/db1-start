package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Cliente;
import com.db1.db1start.cidadesapi.entity.Conta;
import com.db1.db1start.cidadesapi.exception.ClienteNotFoundException;
import com.db1.db1start.cidadesapi.repository.ClienteRepository;
import com.db1.db1start.cidadesapi.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ContaService contaService;

    public Cliente criar(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente atualizar(Long clienteId, String nomeNovo) {
        Cliente cliente = buscarPorId(clienteId);
        cliente.setNome(nomeNovo);
        return clienteRepository.save(cliente);
    }

    public void removerPorId(Long clienteId) {
        try {
            clienteRepository.deleteById(clienteId);
        } catch (Exception e) {
            throw new ClienteNotFoundException();
        }
    }

    public void removerTodos() {
        clienteRepository.deleteAll();
    }

    public Cliente buscarPorId(Long clienteId) {
        return clienteRepository.findById(clienteId).orElseThrow(
                ClienteNotFoundException::new
        );
    }

    public Cliente buscarPorNome(String nome) {
        return clienteRepository.findByNome(nome).orElseThrow(
                ClienteNotFoundException::new
        );
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public void adicionarConta(Long clienteId, Conta conta) {
        Cliente cliente = buscarPorId(clienteId);
        cliente.setConta(conta);
        clienteRepository.save(cliente);
    }
}
