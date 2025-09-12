package com.barbearia.domain;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Usuario{
	
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
	}		
}