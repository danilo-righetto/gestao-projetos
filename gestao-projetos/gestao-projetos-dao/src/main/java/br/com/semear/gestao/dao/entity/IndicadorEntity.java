package br.com.semear.gestao.dao.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "INDICADOR")
public class IndicadorEntity {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ORGAO", nullable = false)
	private OrgaoEntity orgaoEntity;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ELEMENTO", nullable = false)
	private ElementoEntity elementoEntity;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "FORMULA_CALCULO")
	private String formulaCalculo;

	@Column(name = "UNIDADE_MEDIDA_CALCULO")
	private String unidadeMedidaCalculo;

	@Column(name = "POLARIDADE")
	private String polaridade;

	@Column(name = "PERIODICIDADE_APURACAO")
	private String periodicidadeApuracao;

	@Column(name = "ACUMULACAO_TEMPORAL")
	private boolean acumulacaoTemporal;

	@Column(name = "ATIVO")
	private boolean ativo;

	@Column(name = "DATA_CADASTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	@Column(name = "META")
	private double meta;

	@Column(name = "PERCENTUAL")
	private double percentual;

	// Variaveis que identificamos

	@Column(name = "VALOR_REFERENCIA")
	private String valorRefencia;

	@Column(name = "FONTE_INFORMACAO_VLR_REF")
	private String fonteInformacaoVlrRef;

	@Column(name = "BASE_GEOGRAFICA")
	private String baseGeografica;

	@Column(name = "LIMITACOES")
	private String limitacoes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public OrgaoEntity getOrgaoEntity() {
		return orgaoEntity;
	}

	public void setOrgaoEntity(OrgaoEntity orgaoEntity) {
		this.orgaoEntity = orgaoEntity;
	}

	public ElementoEntity getElementoEntity() {
		return elementoEntity;
	}

	public void setElementoEntity(ElementoEntity elementoEntity) {
		this.elementoEntity = elementoEntity;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFormulaCalculo() {
		return formulaCalculo;
	}

	public void setFormulaCalculo(String formulaCalculo) {
		this.formulaCalculo = formulaCalculo;
	}

	public String getUnidadeMedidaCalculo() {
		return unidadeMedidaCalculo;
	}

	public void setUnidadeMedidaCalculo(String unidadeMedidaCalculo) {
		this.unidadeMedidaCalculo = unidadeMedidaCalculo;
	}

	public String getPolaridade() {
		return polaridade;
	}

	public void setPolaridade(String polaridade) {
		this.polaridade = polaridade;
	}

	public String getPeriodicidadeApuracao() {
		return periodicidadeApuracao;
	}

	public void setPeriodicidadeApuracao(String periodicidadeApuracao) {
		this.periodicidadeApuracao = periodicidadeApuracao;
	}

	public boolean isAcumulacaoTemporal() {
		return acumulacaoTemporal;
	}

	public void setAcumulacaoTemporal(boolean acumulacaoTemporal) {
		this.acumulacaoTemporal = acumulacaoTemporal;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public double getMeta() {
		return meta;
	}

	public void setMeta(double meta) {
		this.meta = meta;
	}

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}

	public String getValorRefencia() {
		return valorRefencia;
	}

	public void setValorRefencia(String valorRefencia) {
		this.valorRefencia = valorRefencia;
	}

	public String getFonteInformacaoVlrRef() {
		return fonteInformacaoVlrRef;
	}

	public void setFonteInformacaoVlrRef(String fonteInformacaoVlrRef) {
		this.fonteInformacaoVlrRef = fonteInformacaoVlrRef;
	}

	public String getBaseGeografica() {
		return baseGeografica;
	}

	public void setBaseGeografica(String baseGeografica) {
		this.baseGeografica = baseGeografica;
	}

	public String getLimitacoes() {
		return limitacoes;
	}

	public void setLimitacoes(String limitacoes) {
		this.limitacoes = limitacoes;
	}

}
