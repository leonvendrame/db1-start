package com.db1.db1start.cidadesapi.repository;

import com.db1.db1start.cidadesapi.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Optional<Cidade> findByNome(String nome);
}
