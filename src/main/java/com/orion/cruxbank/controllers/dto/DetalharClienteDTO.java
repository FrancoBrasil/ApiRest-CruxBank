package com.orion.cruxbank.controllers.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.orion.cruxbank.model.Cliente;

public class DetalharClienteDTO {

	private Long id;
	private String nome;
	private Long cpf;
	private LocalDateTime dataNacimento;
	private List<ContaDTO> contas;
	
	public DetalharClienteDTO() {}

	public DetalharClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		cpf = cliente.getCpf();
		dataNacimento = cliente.getDataNascimento();
		contas = new ArrayList<>();
		contas.addAll(cliente.getContas().stream().map(ContaDTO::new).collect(Collectors.toList()));
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
	
	public List<ContaDTO> getContas() {
		return contas;
	}

	public void setContas(List<ContaDTO> contas) {
		this.contas = contas;
	}
	
	
	public static List<DetalharClienteDTO> converter(List<Cliente> clientes) {
		return clientes.stream().map(DetalharClienteDTO::new).collect(Collectors.toList());
	}

}
