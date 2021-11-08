package com.fortmetais.pesagem.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cod_referencia")
	private String codReferencia;
	
	@Column(name = "percentual_perda", precision = 19, scale = 3)
    private BigDecimal percentualPerda;
	
	@Column(name = "peso_unitario", precision = 19, scale = 3)
    private BigDecimal pesoUnitario;

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

	public BigDecimal getPercentualPerda() {
		return percentualPerda;
	}

	public void setPercentualPerda(BigDecimal percentualPerda) {
		this.percentualPerda = percentualPerda;
	}

	public BigDecimal getPesoUnitario() {
		return pesoUnitario;
	}

	public void setPesoUnitario(BigDecimal pesoUnitario) {
		this.pesoUnitario = pesoUnitario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
