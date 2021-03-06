package com.db1.db1start.cidadesapi.repository;

import com.db1.db1start.cidadesapi.entity.Cliente;
import com.db1.db1start.cidadesapi.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    Optional<Conta> findByCliente(Cliente cliente);
}
