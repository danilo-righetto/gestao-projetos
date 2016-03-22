package br.com.semear.gestao.model;

import java.util.Calendar;

public class InformacaoProjeto {
	
	private long id;
	
	private Projeto projeto;
	
	private String informacoes;
	
	private Calendar dataCadastro;
	
	private Calendar dataEdicao;
	
	private Usuario usuario;

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

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataEdicao() {
		return dataEdicao;
	}

	public void setDataEdicao(Calendar dataEdicao) {
		this.dataEdicao = dataEdicao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}