package com.orion.cruxbank.controllers.dto;

import org.springframework.data.domain.Page;

import com.orion.cruxbank.model.Conta;

public class ContaDTO {

	private Long id;
	private Byte agencia;
	private byte numero;

	public ContaDTO() {
	}

	public ContaDTO(Conta conta) {
		id = conta.getId();
		agencia = conta.getAgencia();
		numero = conta.getNumero();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte getAgencia() {
		return agencia;
	}

	public void setAgencia(Byte agencia) {
		this.agencia = agencia;
	}

	public byte getNumero() {
		return numero;
	}

	public void setNumero(byte numero) {
		this.numero = numero;
	}

	public static Page<ContaDTO> converter(Page<Conta> contas) {
		return contas.map(ContaDTO::new);
	}

}
