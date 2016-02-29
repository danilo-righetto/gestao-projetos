package br.com.semear.gestao.model;

import java.util.Calendar;

public class ApuracaoIndicador {
	private long id;
	private Indicador indicador;
	private double periodo;
	private Calendar dataApuracao;
	private double resultado;
	private double variacao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Indicador getIndicador() {
		return indicador;
	}
	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
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
	
	
}
