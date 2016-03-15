package br.com.semear.gestao.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UNIDADE_PRISIONAL")
public class UnidadePrisionalEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "STATUS_UNIDADE", nullable = false)
	private boolean status;

	@OneToMany(mappedBy = "unidadePrisional", fetch = FetchType.LAZY)
	private List<ReeducandoEntity> reeducandos;

	@OneToMany(mappedBy = "unidadePrisional", fetch = FetchType.LAZY)
	private List<InstituicaoEntity> instituicoes;

	@OneToMany(mappedBy = "unidadePrisional", fetch = FetchType.LAZY)
	private List<ProjetoEntity> projetos;

	public UnidadePrisionalEntity(long id) {
		this.id = id;
	}

	public UnidadePrisionalEntity() {

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<ReeducandoEntity> getReeducandos() {
		return reeducandos;
	}

	public void setReeducandos(List<ReeducandoEntity> reeducandos) {
		this.reeducandos = reeducandos;
	}

	public List<InstituicaoEntity> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<InstituicaoEntity> instituicoes) {
		this.instituicoes = instituicoes;
	}
}