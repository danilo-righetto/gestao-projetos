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
@Table(name = "PARTICIPACAO_PROJETO")
public class ParticipacaoProjetoEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJETO", nullable = false)
	private ProjetoEntity projeto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REEDUCANDO", nullable = false)
	private ReeducandoEntity reeducando;

	@Column(name = "DATA_ENTRADA")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEntrada;

	@Column(name = "DATA_SAIDA")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataSaida;

	@Column(name = "MOTIVO_SAIDA")
	private String motivoSaida;

	@Column(name = "FUNCAO")
	private String funcao;

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

	public ReeducandoEntity getReeducando() {
		return reeducando;
	}

	public void setReeducando(ReeducandoEntity reeducando) {
		this.reeducando = reeducando;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getMotivoSaida() {
		return motivoSaida;
	}

	public void setMotivoSaida(String motivoSaida) {
		this.motivoSaida = motivoSaida;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
}