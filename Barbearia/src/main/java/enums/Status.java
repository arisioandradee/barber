package enums;

public enum Status {

	PENDENTE(0, "ROLE PENDENTE"),
	CONCLUIDO(2, "ROLE CONCLUIDO");
	
	private Integer codigo;
	private String descricao;
	
	private Status(Integer codigo, String descricao ) {
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