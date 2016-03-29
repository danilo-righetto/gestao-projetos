package br.com.semear.gestao.dao.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TAREFA_PROJETO")
public class TarefaProjetoEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue
	private long id;

	@Column(name = "DESCRICAO")
	private String descricao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="PROJETO")
	private ProjetoEntity projeto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RESPONSAVEL")
	private UsuarioEntity responsavel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AUTOR")
	private UsuarioEntity autor;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	@Column(name = "DATA_INICIO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataInicio;

	@Column(name = "PREVISAO_TERMINO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar previsaoTermino;

	@Column(name = "DATA_TERMINO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataTermino;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ProjetoEntity getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoEntity projeto) {
		this.projeto = projeto;
	}

	public UsuarioEntity getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(UsuarioEntity responsavel) {
		this.responsavel = responsavel;
	}

	public UsuarioEntity getAutor() {
		return autor;
	}

	public void setAutor(UsuarioEntity autor) {
		this.autor = autor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Calendar getPrevisaoTermino() {
		return previsaoTermino;
	}

	public void setPrevisaoTermino(Calendar previsaoTermino) {
		this.previsaoTermino = previsaoTermino;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}
}