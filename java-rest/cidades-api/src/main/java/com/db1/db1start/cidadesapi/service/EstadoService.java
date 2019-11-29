package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Estado;
import com.db1.db1start.cidadesapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado criar(String nome) {
        Estado estado = new Estado(nome);
        return estadoRepository.save(estado);
    }

    public Estado atualizar(Long estadoId, String novoNome) {
        Estado estado = buscaPorId(estadoId);
        estado.setNome(novoNome);
        return estadoRepository.save(estado);
    }

    public Estado buscaPorNome(String nome) {
        return estadoRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Estado não encontrado"));
    }

    public Estado buscaPorId(Long id) {
        return estadoRepository.findById(id).orElseThrow(() -> new RuntimeException("Estado não encontrado"));
    }

    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();
    }

    public void removerPorNome(String nome) {
        estadoRepository.deleteByNome(nome);
    }

    public void removerPorId(Long id) {
        estadoRepository.deleteById(id);
    }

    public void removerTodos() {;
        estadoRepository.deleteAll();
    }
}
