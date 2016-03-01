package br.com.semear.gestao.dao.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BNT_REQUISICAO_SENHA")
public class RequisicaoSenhaEntity {
	
	@Id
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@Column(name="HASH_URL",nullable=false)
	private String hashUrl;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATA_CADASTRO", nullable=false)
	private Calendar dataCadastro;
	
	/**GETTERS AND SETTERS*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashUrl() {
		return hashUrl;
	}

	public void setHashUrl(String hashUrl) {
		this.hashUrl = hashUrl;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}