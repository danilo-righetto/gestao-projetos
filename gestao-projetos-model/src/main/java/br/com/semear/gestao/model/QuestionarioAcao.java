package br.com.semear.gestao.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class QuestionarioAcao {
	private long id;
	private String descricao;
	private Acao acao;
	private Calendar dataCadastro;
	private List<PerguntaAcao> perguntas = new ArrayList<PerguntaAcao>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public List<PerguntaAcao> getPerguntas() {
		return perguntas;
	}
	public void setPerguntas(List<PerguntaAcao> perguntas) {
		this.perguntas = perguntas;
	}
	public Acao getAcao() {
		return acao;
	}
	public void setAcao(Acao acao) {
		this.acao = acao;
	}
	
	
}
