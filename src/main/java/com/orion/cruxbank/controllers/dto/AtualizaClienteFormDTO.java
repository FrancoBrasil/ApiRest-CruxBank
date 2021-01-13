package com.orion.cruxbank.controllers.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.orion.cruxbank.model.Cliente;
import com.orion.cruxbank.repositories.ClienteRepository;

public class AtualizaClienteFormDTO {
	
	@NotNull @NotEmpty
	private String nome;
	private LocalDateTime dataNacimento;

	public AtualizaClienteFormDTO() {
	}

	public AtualizaClienteFormDTO(Cliente cliente) {
		nome = cliente.getNome();
		dataNacimento = cliente.getDataNascimento();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getDataNacimento() {
		return dataNacimento;
	}

	public void setDataNacimento(LocalDateTime dataNacimento) {
		this.dataNacimento = dataNacimento;
	}

	public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getOne(id);
		cliente.setNome(this.nome);
		cliente.setDataNascimento(this.dataNacimento);
		return cliente;
	}

}
