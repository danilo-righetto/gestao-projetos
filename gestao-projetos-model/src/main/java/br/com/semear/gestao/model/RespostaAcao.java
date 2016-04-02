package br.com.semear.gestao.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RespostaAcao {
	private long id;
	private PerguntaAcao perguntaAcao;
	private String descricaoRespostaAcao;
	private Calendar dataCadastro;
	private Calendar dataAlteracao;
	private Usuario usuario;
	private Acao acao;
	private Reeducando reeducando;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	private List<RespostaAcao> respostas = new ArrayList<RespostaAcao>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public PerguntaAcao getPerguntaAcao() {
		return perguntaAcao;
	}
	public void setPerguntaAcao(PerguntaAcao perguntaAcao) {
		this.perguntaAcao = perguntaAcao;
	}
	public String getDescricaoRespostaAcao() {
		return descricaoRespostaAcao;
	}
	public void setDescricaoRespostaAcao(String descricaoRespostaAcao) {
		this.descricaoRespostaAcao = descricaoRespostaAcao;
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
	public List<RespostaAcao> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<RespostaAcao> respostas) {
		this.respostas = respostas;
	}
	
	
}
