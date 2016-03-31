package br.com.semear.gestao.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Acao {

	private long id;

	private String nome;

	private String descricao;

	private Calendar dataCadastro;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataInicio;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataTermino;

	private String status;

	private Usuario usuario;

	public Acao(Long idAcao) {
		this.id = idAcao;
	}
	
	public Acao() {
		// TODO Auto-generated constructor stub
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}