package br.com.semear.gestao.model;

import java.util.Calendar;

public class ParticipacaoReeducandoAcao {
	
	private long id;

	private Acao acao;

	private Reeducando reeducando;

	private Calendar dataEntrada;

	private Calendar dataSaida;

	private String motivoSaida;

	private String funcao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public Reeducando getReeducando() {
		return reeducando;
	}

	public void setReeducando(Reeducando reeducando) {
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