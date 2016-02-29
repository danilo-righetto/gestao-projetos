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
@Table(name = "PERGUNTA")
public class PerguntaEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "DESCRICAO_PERGUNTA")
	private String descricaoPergunta;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TIPO_PERGUNTA", nullable = false)
	private TipoPerguntaEntity tipoPerguntaentity;

	@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "QUESTIONARIO", nullable = false)
	private QuestionarioEntity questionarioEntity;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USUARIO", nullable = false)
	private UsuarioEntity usuarioEntity;

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

	public QuestionarioEntity getQuestionarioEntity() {
		return questionarioEntity;
	}

	public void setQuestionarioEntity(QuestionarioEntity questionarioEntity) {
		this.questionarioEntity = questionarioEntity;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

}
