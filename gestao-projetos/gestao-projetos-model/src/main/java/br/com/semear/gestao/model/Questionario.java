package br.com.semear.gestao.model;

import java.util.Calendar;
import java.util.List;

public class Questionario {
	private long id;
	private String projeto;
	private Calendar dataCadastro;
	private List<Pergunta> perguntas;
	
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
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	
}
