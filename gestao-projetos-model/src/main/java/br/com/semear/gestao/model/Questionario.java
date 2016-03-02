package br.com.semear.gestao.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Questionario {
	private long id;
	private String descricao;
	private Projeto projeto;
	private Calendar dataCadastro;
	private List<Pergunta> perguntas = new ArrayList<Pergunta>();
	
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public List<Pergunta> getPerguntas() {
		return perguntas;
	}
	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}
	public long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
}
