package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Cidade;
import com.db1.db1start.cidadesapi.entity.Estado;
import com.db1.db1start.cidadesapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public void criar(String nome, Estado estado) {
        Cidade cidade = new Cidade(nome, estado);
        cidadeRepository.save(cidade);
    }

    public void removerPorId(Long id) {
        cidadeRepository.deleteById(id);
    }

    public void limpar() {
        cidadeRepository.deleteAll();
    }

    public Cidade buscaCidadePorNome(String nome) {
        return cidadeRepository.findByNome(nome).orElseThrow(() -> new RuntimeException("Cidade não encontrada"));
    }
}
