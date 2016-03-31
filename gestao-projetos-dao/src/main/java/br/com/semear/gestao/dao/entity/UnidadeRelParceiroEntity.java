package br.com.semear.gestao.dao.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "UNIDADE_REL_PARCEIRO")
public class UnidadeRelParceiroEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UNIDADE", nullable = false)
	private UnidadePrisionalEntity unidadePrisional;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARCEIRO", nullable = false)
	private ParceiroEntity parceiro;

	@Column(name = "DATA_ENTRADA")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEntrada;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UnidadePrisionalEntity getUnidadePrisional() {
		return unidadePrisional;
	}

	public void setUnidadePrisional(UnidadePrisionalEntity unidadePrisional) {
		this.unidadePrisional = unidadePrisional;
	}

	public ParceiroEntity getParceiro() {
		return parceiro;
	}

	public void setParceiro(ParceiroEntity parceiro) {
		this.parceiro = parceiro;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
}