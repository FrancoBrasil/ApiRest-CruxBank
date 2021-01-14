package com.orion.cruxbank.controllers.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.orion.cruxbank.model.Cliente;

public class ClienteFormDTO {
	
	@NotNull @NotEmpty
	private String nome;
	private Long cpf;
	@NotNull
	private LocalDateTime dataNascimento;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public LocalDateTime getDataNacimento() {
		return dataNascimento;
	}

	public void setDataNacimento(LocalDateTime dataNacimento) {
		this.dataNascimento = dataNacimento;
	}

	public Cliente converter() {
		return new Cliente(nome, cpf, dataNascimento);
	}

}
