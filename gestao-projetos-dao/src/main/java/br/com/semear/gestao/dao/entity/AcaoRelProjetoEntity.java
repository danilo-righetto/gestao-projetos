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
@Table(name = "ACAO_REL_PROJETO")
public class AcaoRelProjetoEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACAO", nullable = false)
	private AcaoEntity acao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJETO", nullable = false)
	private ProjetoEntity projeto;
	
	@Column(name = "DATA_ENTRADA")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEntrada;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AcaoEntity getAcao() {
		return acao;
	}

	public void setAcao(AcaoEntity acao) {
		this.acao = acao;
	}

	public ProjetoEntity getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoEntity projeto) {
		this.projeto = projeto;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	
}
