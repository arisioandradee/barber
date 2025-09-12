package com.barbearia.enums;

public enum Perfil {
	
	CLIENTE(0, "ROLE CLIENTE"),
	BARBEIRO(1, "ROLE BARBEIRO");
	
	private Integer id;
	private String descricao;
	
	private Perfil(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}