package com.orion.cruxbank.controllers.dto;

import com.orion.cruxbank.model.Cliente;
import com.orion.cruxbank.model.Conta;
import com.orion.cruxbank.model.Tipo;
import com.orion.cruxbank.repositories.ClienteRepository;

public class ContaFormDTO {

	private Tipo tipo;
	private String cliente;

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Conta converter(ClienteRepository clienteRepository) {
		Cliente clientes = clienteRepository.findByNome(cliente);
		return new Conta(tipo, clientes);
	}

}
