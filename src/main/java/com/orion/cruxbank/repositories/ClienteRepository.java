package com.orion.cruxbank.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.orion.cruxbank.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNome(String nome);

}
