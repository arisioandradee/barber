package enums;

public enum Servico {

	CABELO_SOCIAL(0, "ROLE CABELO_SOCIAL"),
	CABELO_DEGRADE(1, "ROLE CABELO_DEGRADE"),
	BARBA(2, "ROLE BARBA"),
	SOBRANCELHA(3, "ROLE SOBRANCELHA");
	
	private Integer codigo;
	private String descricao;
	
	private Servico(Integer codigo, String descricao) {
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