package com.db1.db1start.cidadesapi.repository;

import com.db1.db1start.cidadesapi.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findByNome(String nome);

    void deleteByNome(String nome);
}
