package br.com.semear.gestao.dao.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ACAO")
public class AcaoEntity {

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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USUARIO", nullable = false)
	private UsuarioEntity usuario;

	@ManyToMany(mappedBy = "acao", fetch = FetchType.LAZY)
	private List<ParticipacaoReeducandoAcaoEntity> participacoes;
	
	@ManyToMany(mappedBy = "acao", fetch = FetchType.LAZY)
	private List<RespostaAcaoEntity> respostas;

	public AcaoEntity(long idAcao) {
		// TODO Auto-generated constructor stub
	}
	
	public AcaoEntity(){
		
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

	public List<ParticipacaoReeducandoAcaoEntity> getParticipacoes() {
		return participacoes;
	}

	public void setParticipacoes(List<ParticipacaoReeducandoAcaoEntity> participacoes) {
		this.participacoes = participacoes;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
}