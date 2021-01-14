package com.orion.cruxbank.controllers.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginFormDTO {
	
	private String email;
	private String senha;
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}
	public UsernamePasswordAuthenticationToken getDadosLogin() {
		return new UsernamePasswordAuthenticationToken(email, senha);
	}
	
	
}
