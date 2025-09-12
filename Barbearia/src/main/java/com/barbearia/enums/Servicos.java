package com.barbearia.enums;

public enum Servicos {

	CORTE_SOCIAL(0, "ROLE CORTE SOCIAL"),
	CORTE_DEGRADE(1, "ROLE CORTE DEGRADE"),
	BARBA_MAQUINA(2, "ROLE BARBA MAQUINA"),
	BARBA_COMPLETA(3, "ROLE BARBA COMPLETA"),
	SOBRANCELHA(4, "ROLE SOBRANCELHA");
	
	private Integer codigo;
	private String descricao;
	
	private Servicos(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
