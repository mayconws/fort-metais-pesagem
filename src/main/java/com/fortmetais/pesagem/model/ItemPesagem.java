package com.fortmetais.pesagem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "item_pesagem")
public class ItemPesagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	@Column(name = "peso_bruto")
	private BigDecimal pesoBruto;
	
	@Column(name = "peso_tara")
	private BigDecimal pesoTara;
	
	@Column(name = "peso_liquido")
	private BigDecimal pesoLiquido;
	
	@ManyToOne
	@JoinColumn(name = "pesagem_id")
	private Pesagem pesagem;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "itemPesagem")
	private List<VolumePesagem> volumesPesagem = new ArrayList<VolumePesagem>();

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

	public Pesagem getPesagem() {
		return pesagem;
	}

	public void setPesagem(Pesagem pesagem) {
		this.pesagem = pesagem;
	}

	public List<VolumePesagem> getVolumesPesagem() {
		return volumesPesagem;
	}

	public void setVolumesPesagem(List<VolumePesagem> volumesPesagem) {
		this.volumesPesagem = volumesPesagem;
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
		ItemPesagem other = (ItemPesagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
