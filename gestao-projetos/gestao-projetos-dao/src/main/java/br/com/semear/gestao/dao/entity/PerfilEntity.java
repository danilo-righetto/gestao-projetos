package br.com.semear.gestao.dao.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERFIL")
public class PerfilEntity {
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "DESCRICAO")
	private String descricao;

	@OneToMany(mappedBy = "perfil", fetch = FetchType.LAZY)
	private List<UsuarioEntity> usuarios;

	public PerfilEntity() {

	}

	public PerfilEntity(String idPerfil) {
		this.id = idPerfil;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
