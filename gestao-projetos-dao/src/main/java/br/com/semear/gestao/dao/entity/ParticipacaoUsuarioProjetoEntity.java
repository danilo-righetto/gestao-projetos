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
@Table(name = "PARTICIPACAO_USUARIO_PROJETO")
public class ParticipacaoUsuarioProjetoEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USUARIO")
	private UsuarioEntity usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PROJETO")
	private ProjetoEntity projeto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_CADASTRO")
	private Calendar dataCadastro;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public ProjetoEntity getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoEntity projeto) {
		this.projeto = projeto;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}