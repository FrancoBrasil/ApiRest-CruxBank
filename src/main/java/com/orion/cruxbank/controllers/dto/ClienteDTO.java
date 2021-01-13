package com.orion.cruxbank.controllers.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.orion.cruxbank.model.Cliente;

public class ClienteDTO {

	private Long id;
	private String nome;
	private Long cpf;
	private LocalDateTime dataNacimento;
	
	public ClienteDTO() {}

	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		cpf = cliente.getCpf();
		dataNacimento = cliente.getDataNascimento();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public LocalDateTime getDataNacimento() {
		return dataNacimento;
	}

	
	public static List<ClienteDTO> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

}
