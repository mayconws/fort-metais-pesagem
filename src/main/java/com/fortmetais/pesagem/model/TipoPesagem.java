package com.fortmetais.pesagem.model;

public enum TipoPesagem {
	
	ENTRADA("Entrada"),
	SAIDA("Saída"),
	DEVOLUCAO("Devolução");
	
	private String descricao;

	TipoPesagem(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
