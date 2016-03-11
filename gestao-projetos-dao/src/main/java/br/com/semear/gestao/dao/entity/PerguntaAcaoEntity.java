package br.com.semear.gestao.dao.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
import javax.persistence.Transient;

@Entity
@Table(name = "PERGUNTA_ACAO")
public class PerguntaAcaoEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "DESCRICAO_PERGUNTA_ACAO")
	private String descricaoPerguntaAcao;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TIPO_PERGUNTA", nullable = false)
	private TipoPerguntaEntity tipoPerguntaentity;

	@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "QUESTIONARIO_ACAO", nullable = false)
	private QuestionarioAcaoEntity questionarioAcaoEntity;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USUARIO", nullable = false)
	private UsuarioEntity usuarioEntity;
	
	@Transient
	private List<AlternativaPerguntaAcaoEntity> alternativas = new ArrayList<AlternativaPerguntaAcaoEntity>();

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

	public TipoPerguntaEntity getTipoPerguntaentity() {
		return tipoPerguntaentity;
	}

	public void setTipoPerguntaentity(TipoPerguntaEntity tipoPerguntaentity) {
		this.tipoPerguntaentity = tipoPerguntaentity;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public QuestionarioAcaoEntity getQuestionarioAcaoEntity() {
		return questionarioAcaoEntity;
	}

	public void setQuestionarioAcaoEntity(QuestionarioAcaoEntity questionarioAcaoEntity) {
		this.questionarioAcaoEntity = questionarioAcaoEntity;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public List<AlternativaPerguntaAcaoEntity> getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(List<AlternativaPerguntaAcaoEntity> alternativas) {
		this.alternativas = alternativas;
	}
	
	
	
}
