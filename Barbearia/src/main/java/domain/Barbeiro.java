package domain;

import enums.Perfil;
import jakarta.persistence.Entity;

@Entity
public class Barbeiro extends Usuario{

	private static final long serialVersionUID = 1L;


	public Barbeiro() {
		super();
		addPerfil(Perfil.BARBEIRO);
	}
	
	public Barbeiro(String nome, String cpf, int idade, String email, String senha) {
		super(nome, cpf, idade, email, senha);
		addPerfil(Perfil.BARBEIRO);
	}
}
