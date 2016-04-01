package br.com.semear.gestao.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class ParticipacaoParceiroProjeto {
	private long id;

	private Projeto projeto;

	private Parceiro parceiro;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataEntrada;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
}