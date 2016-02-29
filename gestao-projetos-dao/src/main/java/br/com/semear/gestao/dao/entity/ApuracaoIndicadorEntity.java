package br.com.semear.gestao.dao.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "APURACAO_INDICADOR")
public class ApuracaoIndicadorEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INDICADOR", nullable = false)
	private IndicadorEntity indicadorEntity;

	@Column(name = "PERIODO")
	private double periodo;

	@Column(name = "DATA_APURACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataApuracao;

	@Column(name = "RESULTADO")
	private double resultado;

	@Column(name = "VARIACAO")
	private double variacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getPeriodo() {
		return periodo;
	}

	public void setPeriodo(double periodo) {
		this.periodo = periodo;
	}

	public Calendar getDataApuracao() {
		return dataApuracao;
	}

	public void setDataApuracao(Calendar dataApuracao) {
		this.dataApuracao = dataApuracao;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	public double getVariacao() {
		return variacao;
	}

	public void setVariacao(double variacao) {
		this.variacao = variacao;
	}

	public IndicadorEntity getIndicadorEntity() {
		return indicadorEntity;
	}

	public void setIndicadorEntity(IndicadorEntity indicadorEntity) {
		this.indicadorEntity = indicadorEntity;
	}

}
