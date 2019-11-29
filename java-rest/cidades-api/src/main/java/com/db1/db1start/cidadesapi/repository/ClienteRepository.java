package com.db1.db1start.cidadesapi.repository;

import com.db1.db1start.cidadesapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByNome(String nome);
}
