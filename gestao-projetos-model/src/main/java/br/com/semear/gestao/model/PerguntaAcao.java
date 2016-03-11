package br.com.semear.gestao.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PerguntaAcao {
	private long id;
	private String descricaoPerguntaAcao;
	private TipoPergunta tipoPergunta;
	private Calendar dataCadastro;
	private QuestionarioAcao questionarioAcao;
	private Usuario usuario;
	private List<AlternativaPerguntaAcao> alternativas =  new ArrayList<AlternativaPerguntaAcao>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescricaoPerguntaAcao() {
		return descricaoPerguntaAcao;
	}
	public void setDescricaoPerguntaAcao(String descricaoPerguntaAcao) {
		this.descricaoPerguntaAcao = descricaoPerguntaAcao;
	}
	public TipoPergunta getTipoPergunta() {
		return tipoPergunta;
	}
	public void setTipoPergunta(TipoPergunta tipoPergunta) {
		this.tipoPergunta = tipoPergunta;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public QuestionarioAcao getQuestionarioAcao() {
		return questionarioAcao;
	}
	public void setQuestionarioAcao(QuestionarioAcao questionarioAcao) {
		this.questionarioAcao = questionarioAcao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<AlternativaPerguntaAcao> getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(List<AlternativaPerguntaAcao> alternativas) {
		this.alternativas = alternativas;
	}
	
	
}
