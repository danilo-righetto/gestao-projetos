package br.com.semear.gestao.dao.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COLABORADOR")
public class ColaboradorEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "EMAIL")
	private String email;

	@JoinColumn(name = "USUARIO")
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private UsuarioEntity usuario;

	@JoinColumn(name = "PARCEIRO")
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	private ParceiroEntity parceiro;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public ParceiroEntity getParceiro() {
		return parceiro;
	}

	public void setParceiro(ParceiroEntity parceiro) {
		this.parceiro = parceiro;
	}
}