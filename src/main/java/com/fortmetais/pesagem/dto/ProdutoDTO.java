package com.fortmetais.pesagem.dto;

public class ProdutoDTO {
	
	private Long id;
	private String nome;
	private String codReferencia;
	
	public ProdutoDTO(Long id, String nome, String codReferencia) {
		super();
		this.id = id;
		this.nome = nome;
		this.codReferencia = codReferencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodReferencia() {
		return codReferencia;
	}

	public void setCodReferencia(String codReferencia) {
		this.codReferencia = codReferencia;
	}

}
