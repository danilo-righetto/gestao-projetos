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
@Table(name = "PARTICIPACAO_PARCEIRO_PROJETO")
public class ParticipacaoParceiroProjetoEntity {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJETO", nullable = false)
	private ProjetoEntity projeto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PARCEIRO", nullable = false)
	private ParceiroEntity parceiro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_ENTRADA", nullable = false)
	private Calendar dataEntrada;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProjetoEntity getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoEntity projeto) {
		this.projeto = projeto;
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