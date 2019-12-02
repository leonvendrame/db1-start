package com.db1.db1start.cidadesapi.service;

import com.db1.db1start.cidadesapi.entity.Agencia;
import com.db1.db1start.cidadesapi.entity.Cidade;
import com.db1.db1start.cidadesapi.repository.AgenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaService {

    @Autowired
    private AgenciaRepository agenciaRepository;

    public Agencia criar(Cidade cidade, String numeroAgencia, String numeroBanco) {
        Agencia agencia = new Agencia(cidade, numeroAgencia, numeroBanco);
        return agenciaRepository.save(agencia);
    }

    public Agencia atualizar(Long agenciaId, String numeroAgenciaNovo, String numeroBancoNovo) {
        Agencia agencia = buscarPorId(agenciaId);
        agencia.setNumeroAgencia(numeroAgenciaNovo);
        agencia.setNumeroBanco(numeroBancoNovo);
        return agenciaRepository.save(agencia);
    }

    public void removerPorId(Long agenciaId) {
        agenciaRepository.deleteById(agenciaId);
    }

    public void removerTodos() {
        agenciaRepository.deleteAll();
    }

    public Agencia buscarPorId(Long agenciaId) {
        return agenciaRepository.findById(agenciaId).orElseThrow(
                () -> new RuntimeException("Agência não encontrada")
        );
    }

    public Agencia buscarPorNumeroAgencia(String numeroAgencia) {
        return agenciaRepository.findByNumeroAgencia(numeroAgencia).orElseThrow(
                () -> new RuntimeException("Agencia não encontrada")
        );
    }

    public List<Agencia> buscarTodas() {
        return agenciaRepository.findAll();
    }
}
