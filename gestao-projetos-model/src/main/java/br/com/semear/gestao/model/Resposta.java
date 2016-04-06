package br.com.semear.gestao.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Resposta {
	private long id;
	private Pergunta pergunta;
	private String descricaoResposta;
	private Calendar dataCadastro;
	private Calendar dataAlteracao;
	private Usuario usuario;
	private Projeto projeto;
	private Reeducando reeducando;
	private String tipo;
	private String respostaStatus;
	
	public String getRespostaStatus() {
		return respostaStatus;
	}
	public void setRespostaStatus(String respostaStatus) {
		this.respostaStatus = respostaStatus;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	public Reeducando getReeducando() {
		return reeducando;
	}
	public void setReeducando(Reeducando reeducando) {
		this.reeducando = reeducando;
	}
	private List<Resposta> respostas = new ArrayList<Resposta>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Pergunta getPergunta() {
		return pergunta;
	}
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	public String getDescricaoResposta() {
		return descricaoResposta;
	}
	public void setDescricaoResposta(String descricaoResposta) {
		this.descricaoResposta = descricaoResposta;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}
	
}
