package br.com.semear.gestao.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTRO_INFORMACAO")
public class RegistroInformacaoEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Column(name = "ANO")
	private int ano;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "VALOR")
	private double valor;

	@Column(name = "UNIDADE_MEDIDA")
	private String unidadeMedida;

	@Column(name = "FONTE_INFORMACAO")
	private String fonteInformacao;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getFonteInformacao() {
		return fonteInformacao;
	}

	public void setFonteInformacao(String fonteInformacao) {
		this.fonteInformacao = fonteInformacao;
	}

}
