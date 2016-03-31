package br.com.semear.gestao.dao.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RESPOSTA_ACAO")
public class RespostaAcaoEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PERGUNTA", nullable = false)
	private PerguntaAcaoEntity perguntaAcaoEntity;

	@Column(name = "DESCRICAO_RESPOSTA_ACAO")
	private String descricaoRespostaAcao;

	@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	@Column(name = "DATA_ALTERACAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAlteracao;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USUARIO", nullable = false)
	private UsuarioEntity usuarioEntity;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REEDUCANDO", nullable = false)
	private ReeducandoEntity reeducandoEntity;
	
	@Column(name = "RESPOSTA_STATUS")
	private String respostaStatus;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ACAO")
	private AcaoEntity acao;
	

	public AcaoEntity getAcao() {
		return acao;
	}

	public void setAcao(AcaoEntity acao) {
		this.acao = acao;
	}

	public ReeducandoEntity getReeducandoEntity() {
		return reeducandoEntity;
	}

	public void setReeducandoEntity(ReeducandoEntity reeducandoEntity) {
		this.reeducandoEntity = reeducandoEntity;
	}

	public String getRespostaStatus() {
		return respostaStatus;
	}

	public void setRespostaStatus(String respostaStatus) {
		this.respostaStatus = respostaStatus;
	}

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

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}
	
	
}
