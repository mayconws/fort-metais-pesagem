package com.fortmetais.pesagem.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "volume_pesagem")
public class VolumePesagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String produtoTemporario;
	
	@Column(name = "peso_bruto")
	private BigDecimal pesoBruto;
	
	@Column(name = "peso_tara")
	private BigDecimal pesoTara;
	
	@Column(name = "peso_liquido")
	private BigDecimal pesoLiquido;
	
	@ManyToOne
	@JoinColumn(name = "item_pesagem_id")
	private ItemPesagem itemPesagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(BigDecimal pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public BigDecimal getPesoTara() {
		return pesoTara;
	}

	public void setPesoTara(BigDecimal pesoTara) {
		this.pesoTara = pesoTara;
	}

	public BigDecimal getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(BigDecimal pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public ItemPesagem getItemPesagem() {
		return itemPesagem;
	}

	public void setItemPesagem(ItemPesagem itemPesagem) {
		this.itemPesagem = itemPesagem;
	}
	
	public String getProdutoTemporario() {
		return produtoTemporario;
	}

	public void setProdutoTemporario(String produtoTemporario) {
		this.produtoTemporario = produtoTemporario;
	}

	public BigDecimal getPesoLiquidoTotal() {
		return pesoBruto.subtract(pesoTara);
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
		VolumePesagem other = (VolumePesagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
