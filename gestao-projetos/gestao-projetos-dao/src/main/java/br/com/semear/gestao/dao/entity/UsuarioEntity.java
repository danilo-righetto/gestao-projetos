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
@Table(name = "USUARIO")
public class UsuarioEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "USUARIO", unique = true, nullable = false)
	private String usuario;

	@Column(name = "SENHA", nullable = false)
	private String senha;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PERFIL", nullable = false)
	private PerfilEntity perfil;

	@Column(name="REALIZA_LOGIN" ,nullable = false)
	private Boolean realizaLogin;

	@OneToMany(mappedBy = "usuarioEntity", fetch = FetchType.LAZY)
	private List<ProjetoEntity> projetos;

	public PerfilEntity getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getRealizaLogin() {
		return realizaLogin;
	}

	public void setRealizaLogin(Boolean realizaLogin) {
		this.realizaLogin = realizaLogin;
	}
}
