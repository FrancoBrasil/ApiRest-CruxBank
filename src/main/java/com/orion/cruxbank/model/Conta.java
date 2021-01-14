package com.orion.cruxbank.model;

import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Conta {

	Random random = new Random();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDateTime dataAbertura = LocalDateTime.now();
	private Byte agencia = geradorDeAgencia();
	private Byte numero = geradorDeNumero();
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	protected Double saldo = 0.0;
	private Boolean isAtiva = true;

	@ManyToOne
	private Cliente cliente;

	public Conta() {
	}

	public Conta(Tipo tipo, Cliente cliente) {
		this.tipo = tipo;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Byte getAgencia() {
		return agencia;
	}

	public void setAgencia(Byte agencia) {
		this.agencia = agencia;
	}

	public Byte getNumero() {
		return numero;
	}

	public void setNumero(Byte numero) {
		this.numero = numero;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipoConta(Tipo tipo) {
		this.tipo = tipo;
	}

	public Boolean getIsAtiva() {
		return isAtiva;
	}

	public void setIsAtiva(Boolean isAtiva) {
		this.isAtiva = isAtiva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getSaldo() {
		return saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Byte geradorDeAgencia() {
		byte x = (byte) random.nextInt();
		byte r = (byte) ((x * 2) + x);
		if (r < 0) {
			return (byte) (r * (-1));
		}
		return r;
	}

	public Byte geradorDeNumero() {
		byte x = (byte) random.nextInt();
		byte r = (byte) ((x * 2) + x);

		if (r < 0) {
			return (byte) (r * (-1));
		}
		return r;
	}

	public LocalDateTime dataAtual() {
		return LocalDateTime.now();
	}

}
