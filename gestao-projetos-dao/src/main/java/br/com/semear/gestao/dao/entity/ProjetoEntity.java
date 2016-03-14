package br.com.semear.gestao.dao.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PROJETO")
public class ProjetoEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	@Column(name = "DATA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInicio;

	@Column(name = "DATA_TERMINO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataTermino;

	@Column(name = "STATUS")
	private String status;

	// usuario que criou o projeto
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USUARIO", nullable = false)
	private UsuarioEntity usuarioEntity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COORDENADOR")
	private UsuarioEntity coordenador;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UNIDADE_PRISIONAL")
	private UnidadePrisionalEntity unidadePrisional;

	@OneToMany(mappedBy = "projeto", fetch = FetchType.LAZY)
	private List<ParticipacaoReeducandoProjetoEntity> participacoes;

	public ProjetoEntity() {

	}

	public ProjetoEntity(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public UsuarioEntity getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(UsuarioEntity coordenador) {
		this.coordenador = coordenador;
	}

	public UnidadePrisionalEntity getUnidadePrisional() {
		return unidadePrisional;
	}

	public void setUnidadePrisional(UnidadePrisionalEntity unidadePrisional) {
		this.unidadePrisional = unidadePrisional;
	}

	public List<ParticipacaoReeducandoProjetoEntity> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<ParticipacaoReeducandoProjetoEntity> participacoes) {
		this.participacoes = participacoes;
	}
}