package br.com.semear.gestao.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Pergunta {
	private long id;
	private String descricaoPergunta;
	private TipoPergunta tipoPergunta;
	private Calendar dataCadastro;
	private Questionario questionario;
	private Usuario usuario;
	private List<AlternativaPergunta> alternativas =  new ArrayList<AlternativaPergunta>();
	
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
	public List<AlternativaPergunta> getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(List<AlternativaPergunta> alternativas) {
		this.alternativas = alternativas;
	}
}
