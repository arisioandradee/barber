package com.barbearia.domain;

import com.barbearia.enums.Perfil;

import jakarta.persistence.Entity;

@Entity
public class Barbeiro extends Usuario{

	private static final long serialVersionUID = 1L;
	
	public Barbeiro() {
		super();
		addPerfil(Perfil.BARBEIRO);
	}
	
	public Barbeiro(String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
		addPerfil(Perfil.BARBEIRO);
	}
}