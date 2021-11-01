package com.fortmetais.pesagem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transformacao_produto")
public class TransformacaoProduto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	@ManyToOne
	private Produto produto;
	@Column(name = "valor_perda")
	private BigDecimal valorPerda;
	@Column(name = "peso_total")
	private BigDecimal pesoTotal;	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public BigDecimal getValorPerda() {
		return valorPerda;
	}
	public void setValorPerda(BigDecimal valorPerda) {
		this.valorPerda = valorPerda;
	}
	public BigDecimal getPesoTotal() {
		return pesoTotal;
	}
	public void setPesoTotal(BigDecimal pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransformacaoProduto other = (TransformacaoProduto) obj;
		return Objects.equals(id, other.id);
	}	

}
