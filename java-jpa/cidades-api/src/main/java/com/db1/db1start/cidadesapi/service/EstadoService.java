package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Estado;
import com.db1.db1start.cidadesapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado criar(String nome) {
        Estado estado = new Estado(nome);
        return estadoRepository.save(estado);
    }

    public void limpar() {;
        estadoRepository.deleteAll();
    }

    public Estado buscaEstadoPorNome(String nome) {
        return estadoRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Estado não encontrado"));
    }

    public void removerPorId(Long id) {
        estadoRepository.deleteById(id);
    }
}
