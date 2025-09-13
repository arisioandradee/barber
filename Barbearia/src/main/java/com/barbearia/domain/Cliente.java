package com.barbearia.domain;

import com.barbearia.dto.ClienteDTO;
import com.barbearia.enums.Perfil;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Usuario{
	
	private static final long serialVersionUID = 1L;

	public Cliente(ClienteDTO dto) {
	    this.setId(dto.getId());
	    this.setNome(dto.getNome());
	    this.setCpf(dto.getCpf());
	    this.setEmail(dto.getEmail());
	    addPerfil(Perfil.CLIENTE);
	}

	public Cliente() {
		super();
	}
	
	public Cliente(String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
	}		
	
}