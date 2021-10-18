package com.fortmetais.pesagem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "pesagem")
public class Pesagem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data_lancamento")
	private LocalDate dataLancamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pesagem")
	private TipoPesagem tipoPesagem = TipoPesagem.ENTRADA;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@Column(name = "transportadora")
	private String transportadora;
	
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column(name = "observacao")
	private String observacao;
	
	@Column(name = "total_peso_bruto")
	private BigDecimal totalPesoBruto;
	
	@Column(name = "total_percentual_perda")
	private BigDecimal totalPercentualPerda;
	
	@Column(name = "total_peso_liquido")
	private BigDecimal totalPesoLiquido;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "pesagem")
	private List<ItemPesagem> itensPesagem = new ArrayList<ItemPesagem>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public TipoPesagem getTipoPesagem() {
		return tipoPesagem;
	}

	public void setTipoPesagem(TipoPesagem tipoPesagem) {
		this.tipoPesagem = tipoPesagem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public BigDecimal getTotalPesoBruto() {
		return totalPesoBruto;
	}

	public void setTotalPesoBruto(BigDecimal totalPesoBruto) {
		this.totalPesoBruto = totalPesoBruto;
	}

	public BigDecimal getTotalPercentualPerda() {
		return totalPercentualPerda;
	}

	public void setTotalPercentualPerda(BigDecimal totalPercentualPerda) {
		this.totalPercentualPerda = totalPercentualPerda;
	}

	public BigDecimal getTotalPesoLiquido() {
		return totalPesoLiquido;
	}

	public void setTotalPesoLiquido(BigDecimal totalPesoLiquido) {
		this.totalPesoLiquido = totalPesoLiquido;
	}

	public List<ItemPesagem> getItensPesagem() {
		return itensPesagem;
	}

	public void setItensPesagem(List<ItemPesagem> itensPesagem) {
		this.itensPesagem = itensPesagem;
	}

	public String getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(String transportadora) {
		this.transportadora = transportadora;
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
		Pesagem other = (Pesagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
