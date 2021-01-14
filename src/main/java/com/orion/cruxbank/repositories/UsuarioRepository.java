package com.orion.cruxbank.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orion.cruxbank.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);

}
