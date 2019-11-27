package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Cliente;
import com.db1.db1start.cidadesapi.entity.Conta;
import com.db1.db1start.cidadesapi.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public void criar(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        clienteRepository.save(cliente);
    }

    public Cliente buscarPorNome(String nome) {
        return clienteRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void limpar() {
        clienteRepository.deleteAll();
    }

    public void removerPorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public void adicionarConta(Conta conta, Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new RuntimeException(
                "Cliente não encontrado"
        ));
        cliente.setConta(conta);
        clienteRepository.save(cliente);
    }
}
