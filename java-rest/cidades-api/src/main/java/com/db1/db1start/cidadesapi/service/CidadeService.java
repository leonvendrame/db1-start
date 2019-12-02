package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Cidade;
import com.db1.db1start.cidadesapi.entity.Estado;
import com.db1.db1start.cidadesapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade criar(String nome, Estado estado) {
        Cidade cidade = new Cidade(nome, estado);
        return cidadeRepository.save(cidade);
    }

    public Cidade atualizar(Long cidadeId, String nomeNovo) {
        Cidade cidade = cidadeRepository.findById(cidadeId).orElseThrow(
                () -> new RuntimeException("Cidade não encontraada")
        );
        cidade.setNome(nomeNovo);
        return cidadeRepository.save(cidade);
    }

    public void removerPorId(Long cidadeId) {
        cidadeRepository.deleteById(cidadeId);
    }

    public void removerTodas() {
        cidadeRepository.deleteAll();
    }

    public Cidade buscarPorId(Long cidadeId) {
        return cidadeRepository.findById(cidadeId).orElseThrow(
                () -> new RuntimeException("Cidade não encontrada")
        );
    }

    public Cidade buscaCidadePorNome(String nome) {
        return cidadeRepository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Cidade não encontrada")
        );
    }

    public List<Cidade> buscarTodas() {
        return cidadeRepository.findAll();
    }
}
