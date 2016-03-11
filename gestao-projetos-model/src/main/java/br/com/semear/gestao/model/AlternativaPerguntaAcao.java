package br.com.semear.gestao.model;

import java.util.Calendar;

public class AlternativaPerguntaAcao {
	private long id;
	private PerguntaAcao perguntaAcao;
	private String descricaoAlternativa;
	private Calendar dataCadastro;
	
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
	public String getDescricaoAlternativa() {
		return descricaoAlternativa;
	}
	public void setDescricaoAlternativa(String descricaoAlternativa) {
		this.descricaoAlternativa = descricaoAlternativa;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
}
