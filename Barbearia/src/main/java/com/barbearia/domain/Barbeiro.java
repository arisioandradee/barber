package com.barbearia.domain;

import com.barbearia.dto.BarbeiroDTO;
import com.barbearia.enums.Perfil;

import jakarta.persistence.Entity;

@Entity
public class Barbeiro extends Usuario{

	private static final long serialVersionUID = 1L;
	
	public Barbeiro(BarbeiroDTO dto) {
	    this.setId(dto.getId());
	    this.setNome(dto.getNome());
	    this.setCpf(dto.getCpf());
	    this.setEmail(dto.getEmail());
	    addPerfil(Perfil.CLIENTE);
	}
	
	public Barbeiro() {
		super();
		addPerfil(Perfil.BARBEIRO);
	}
	
	public Barbeiro(String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
		addPerfil(Perfil.BARBEIRO);
	}
}