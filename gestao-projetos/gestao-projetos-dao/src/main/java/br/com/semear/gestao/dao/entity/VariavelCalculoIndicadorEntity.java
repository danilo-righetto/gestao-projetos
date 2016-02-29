package br.com.semear.gestao.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VARIAVEL_CALCULO_INDICADOR")
public class VariavelCalculoIndicadorEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "INDICADOR", nullable = false)
	private IndicadorEntity indicadorEntity;

	@Column(name = "CHAVE_LETRA")
	private String chaveLetra;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REGISTRO_INFORMACAO", nullable = false)
	private RegistroInformacaoEntity registroInformacaoEntity;

	public RegistroInformacaoEntity getRegistroInformacaoEntity() {
		return registroInformacaoEntity;
	}

	public void setRegistroInformacaoEntity(RegistroInformacaoEntity registroInformacaoEntity) {
		this.registroInformacaoEntity = registroInformacaoEntity;
	}

	public String getChaveLetra() {
		return chaveLetra;
	}

	public void setChaveLetra(String chaveLetra) {
		this.chaveLetra = chaveLetra;
	}

	public IndicadorEntity getIndicadorEntity() {
		return indicadorEntity;
	}

	public void setIndicadorEntity(IndicadorEntity indicadorEntity) {
		this.indicadorEntity = indicadorEntity;
	}

}
