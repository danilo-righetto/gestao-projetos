package br.com.semear.gestao.dao.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ALTERNATIVA_PERGUNTA_ACAO")
public class AlternativaPerguntaAcaoEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PERGUNTA_ACAO", nullable = false)
	private PerguntaAcaoEntity perguntaAcaoEntity;

	@Column(name = "DESCRICAO_ALTERNATIVA")
	private String descricaoAlternativaAcao;

	@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PerguntaAcaoEntity getPerguntaAcaoEntity() {
		return perguntaAcaoEntity;
	}

	public void setPerguntaAcaoEntity(PerguntaAcaoEntity perguntaAcaoEntity) {
		this.perguntaAcaoEntity = perguntaAcaoEntity;
	}

	public String getDescricaoAlternativaAcao() {
		return descricaoAlternativaAcao;
	}

	public void setDescricaoAlternativaAcao(String descricaoAlternativaAcao) {
		this.descricaoAlternativaAcao = descricaoAlternativaAcao;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
}
