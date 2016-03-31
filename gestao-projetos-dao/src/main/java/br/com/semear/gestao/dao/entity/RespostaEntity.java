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

import br.com.semear.gestao.model.Projeto;

@Entity
@Table(name = "RESPOSTA_PROJETO")
public class RespostaEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PERGUNTA", nullable = false)
	private PerguntaEntity perguntaEntity;

	@Column(name = "DESCRICAO_RESPOSTA")
	private String descricaoResposta;

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
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJETO", nullable = false)
	private ProjetoEntity projetoEntity;
	
	@Column(name = "RESPOSTA_STATUS")
	private String respostaStatus;
	
	

	public ProjetoEntity getProjetoEntity() {
		return projetoEntity;
	}

	public void setProjetoEntity(ProjetoEntity projetoEntity) {
		this.projetoEntity = projetoEntity;
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

	public PerguntaEntity getPerguntaEntity() {
		return perguntaEntity;
	}

	public void setPerguntaEntity(PerguntaEntity perguntaEntity) {
		this.perguntaEntity = perguntaEntity;
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

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

}
