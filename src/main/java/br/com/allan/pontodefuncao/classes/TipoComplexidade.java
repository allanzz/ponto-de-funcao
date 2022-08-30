package br.com.allan.pontodefuncao.classes;

public enum TipoComplexidade {
	SIMPLES("Simples"),MEDIA("Média"),COMPLEXA("Complexa");
	
	private String descricao;
	TipoComplexidade(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		return this.descricao;
	}
}
