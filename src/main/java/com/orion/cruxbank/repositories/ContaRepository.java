package com.orion.cruxbank.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.orion.cruxbank.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	Page<Conta> findByTipo(String tipo, Pageable paginacao);

}
