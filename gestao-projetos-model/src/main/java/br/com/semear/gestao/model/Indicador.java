package br.com.semear.gestao.model;

import java.util.Calendar;

public class Indicador {
	private long id;
	private Orgao orgao;
	private Elemento elemento;
	private String nome;
	private String descricao;
	private String formulaCalculo;
	private String unidadeMedidaCalculo;
	private String polaridade;
	private String periodicidadeApuracao;
	private boolean acumulacaoTemporal;
	private boolean ativo;
	private Calendar dataCadastro;
	private double meta;
	private double percentual;
	
	//Variaveis que identificamos
	
	private String valorRefencia;
	private String fonteInformacaoVlrRef;
	private String baseGeografica;
	private String limitacoes;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Orgao getOrgao() {
		return orgao;
	}
	public void setOrgao(Orgao orgao) {
		this.orgao = orgao;
	}
	public Elemento getElemento() {
		return elemento;
	}
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
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
