package domain;

import enums.Perfil;
import jakarta.persistence.Entity;

@Entity
public class Cliente extends Usuario{

	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}
	
	public Cliente(String nome, String cpf, int idade, String email, String senha) {
		super(nome, cpf, idade, email, senha);
		addPerfil(Perfil.CLIENTE);
	}
}