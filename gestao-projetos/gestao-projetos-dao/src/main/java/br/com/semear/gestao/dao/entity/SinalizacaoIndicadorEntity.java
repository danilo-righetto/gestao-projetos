package br.com.semear.gestao.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SINALIZACAO_INDICADOR")
public class SinalizacaoIndicadorEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INDICADOR", nullable = false)
	private IndicadorEntity indicadorEntity;

	@Column(name = "SINALIZADOR_VERMELHO_SINAL")
	private String sinalizadorVermelhoSinal;

	@Column(name = "SINALIZADOR_VERMELHO_VALOR")
	private double sinalizadorVermelhoValor;

	@Column(name = "SINALIZADOR_AMARELO_SINAL")
	private String sinalizadorAmareloSinal;

	@Column(name = "SINALIZADOR_AMARELO_VALOR")
	private double sinalizadorAmareloValor;

	@Column(name = "SINALIZADOR_VERDE_SINAL")
	private String sinalizadorVerdeSinal;

	@Column(name = "SINALIZADOR_VERDE_VALOR")
	private double sinalizadorVerdeValor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSinalizadorVermelhoSinal() {
		return sinalizadorVermelhoSinal;
	}

	public void setSinalizadorVermelhoSinal(String sinalizadorVermelhoSinal) {
		this.sinalizadorVermelhoSinal = sinalizadorVermelhoSinal;
	}

	public double getSinalizadorVermelhoValor() {
		return sinalizadorVermelhoValor;
	}

	public void setSinalizadorVermelhoValor(double sinalizadorVermelhoValor) {
		this.sinalizadorVermelhoValor = sinalizadorVermelhoValor;
	}

	public String getSinalizadorAmareloSinal() {
		return sinalizadorAmareloSinal;
	}

	public void setSinalizadorAmareloSinal(String sinalizadorAmareloSinal) {
		this.sinalizadorAmareloSinal = sinalizadorAmareloSinal;
	}

	public double getSinalizadorAmareloValor() {
		return sinalizadorAmareloValor;
	}

	public void setSinalizadorAmareloValor(double sinalizadorAmareloValor) {
		this.sinalizadorAmareloValor = sinalizadorAmareloValor;
	}

	public String getSinalizadorVerdeSinal() {
		return sinalizadorVerdeSinal;
	}

	public void setSinalizadorVerdeSinal(String sinalizadorVerdeSinal) {
		this.sinalizadorVerdeSinal = sinalizadorVerdeSinal;
	}

	public double getSinalizadorVerdeValor() {
		return sinalizadorVerdeValor;
	}

	public void setSinalizadorVerdeValor(double sinalizadorVerdeValor) {
		this.sinalizadorVerdeValor = sinalizadorVerdeValor;
	}

	public IndicadorEntity getIndicadorEntity() {
		return indicadorEntity;
	}

	public void setIndicadorEntity(IndicadorEntity indicadorEntity) {
		this.indicadorEntity = indicadorEntity;
	}

}
