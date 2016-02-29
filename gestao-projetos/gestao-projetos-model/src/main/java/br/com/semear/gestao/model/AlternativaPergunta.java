package br.com.semear.gestao.model;

import java.util.Calendar;

public class AlternativaPergunta {
	private long id;
	private Pergunta pergunta;
	private String descricaoAlternativa;
	private Calendar dataCadastro;
	
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
