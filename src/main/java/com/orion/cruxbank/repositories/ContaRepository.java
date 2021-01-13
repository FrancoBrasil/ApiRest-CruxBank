package com.orion.cruxbank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.orion.cruxbank.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	List<Conta> findByClienteNome(String nome);

}
