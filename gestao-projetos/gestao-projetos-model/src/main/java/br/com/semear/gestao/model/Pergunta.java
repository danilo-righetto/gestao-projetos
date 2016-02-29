package br.com.semear.gestao.model;

import java.util.Calendar;

public class Pergunta {
	private long id;
	private String descricaoPergunta;
	private TipoPergunta tipoPergunta;
	private Calendar dataCadastro;
	private Questionario questionario;
	private Usuario usuario;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricaoPergunta() {
		return descricaoPergunta;
	}
	public void setDescricaoPergunta(String descricaoPergunta) {
		this.descricaoPergunta = descricaoPergunta;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Questionario getQuestionario() {
		return questionario;
	}
	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public TipoPergunta getTipoPergunta() {
		return tipoPergunta;
	}
	public void setTipoPergunta(TipoPergunta tipoPergunta) {
		this.tipoPergunta = tipoPergunta;
	}
	
	
}
