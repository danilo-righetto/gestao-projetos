package br.com.semear.gestao.model;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Reeducando {
	private long id;

	private String matricula;

	private String nome;

	private String sexo;
	
	private String cidade;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Calendar dataNascimento;

	private Calendar dataCadastro;

	private UnidadePrisional unidadePrisional;

	public Reeducando(Long id) {
		this.id = id;
	}
	
	public Reeducando() {
		
	}

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

	public UnidadePrisional getUnidadePrisional() {
		return unidadePrisional;
	}

	public void setUnidadePrisional(UnidadePrisional unidadePrisional) {
		this.unidadePrisional = unidadePrisional;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}