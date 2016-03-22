package br.com.semear.gestao.dao.entity;

import java.util.Calendar;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "REEDUCANDO")
public class ReeducandoEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "MATRICULA", unique = true)
	private String matricula;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "SEXO")
	private String sexo;
	
	@Column(name = "CIDADE")
	private String cidade;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_NASCIMENTO")
	private Calendar dataNascimento;

	@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UNIDADE_PRISIONAL", nullable = false)
	private UnidadePrisionalEntity unidadePrisional;
	
	@JoinColumn(name="USUARIO")
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private UsuarioEntity usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public UnidadePrisionalEntity getUnidadePrisional() {
		return unidadePrisional;
	}

	public void setUnidadePrisional(UnidadePrisionalEntity unidadePrisional) {
		this.unidadePrisional = unidadePrisional;
	}
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
}