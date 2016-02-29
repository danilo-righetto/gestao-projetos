package br.com.semear.gestao.model;

public class VariavelCalculoIndicador {
	private Indicador indicador;
	private String chaveLetra;
	private RegistroInformacao registroInformacao;
	
	public Indicador getIndicador() {
		return indicador;
	}
	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}
	public String getChaveLetra() {
		return chaveLetra;
	}
	public void setChaveLetra(String chaveLetra) {
		this.chaveLetra = chaveLetra;
	}
	public RegistroInformacao getRegistroInformacao() {
		return registroInformacao;
	}
	public void setRegistroInformacao(RegistroInformacao registroInformacao) {
		this.registroInformacao = registroInformacao;
	}
	
	
}
