package com.db1.db1start.cidadesapi.repository;

import com.db1.db1start.cidadesapi.entity.Agencia;
import com.db1.db1start.cidadesapi.entity.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

    Optional<Agencia> findByCidade(Cidade cidade);

    Optional<Agencia> findByNumeroAgencia(String numeroAgencia);
}
