package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Agencia;
import com.db1.db1start.cidadesapi.entity.Cidade;
import com.db1.db1start.cidadesapi.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenciaService {

    @Autowired
    AgenciaRepository agenciaRepository;

    public void criar(Cidade cidade, String numeroAgencia, String numeroBanco) {
        Agencia agencia = new Agencia(cidade, numeroAgencia, numeroBanco);
        agenciaRepository.save(agencia);
    }

    public Agencia buscarPorCidade(Cidade cidade) {
        return agenciaRepository.findByCidade(cidade).orElseThrow(() -> new RuntimeException("Não existem agências na cidade"));
    }

    public void removerPorId(Long id) {
        agenciaRepository.deleteById(id);
    }

    public void limpar() {
        agenciaRepository.deleteAll();
    }

    public Agencia buscarPorNumeroAgencia(String numeroAgencia) {
        return agenciaRepository.findByNumeroAgencia(numeroAgencia).orElseThrow(() -> new RuntimeException("Agencia não encontrada"));
    }
}
