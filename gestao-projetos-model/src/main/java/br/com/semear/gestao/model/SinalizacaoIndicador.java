package br.com.semear.gestao.model;

public class SinalizacaoIndicador {
	private long id;
	private Indicador indicador;
	private String sinalizadorVermelhoSinal;
	private double sinalizadorVermelhoValor;
	private String sinalizadorAmareloSinal;
	private double sinalizadorAmareloValor;
	private String sinalizadorVerdeSinal;
	private double sinalizadorVerdeValor;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Indicador getIndicador() {
		return indicador;
	}
	public void setIndicador(Indicador indicador) {
		this.indicador = indicador;
	}
	public String getSinalizadorVermelhoSinal() {
		return sinalizadorVermelhoSinal;
	}
	public void setSinalizadorVermelhoSinal(String sinalizadorVermelhoSinal) {
		this.sinalizadorVermelhoSinal = sinalizadorVermelhoSinal;
	}
	public double getSinalizadorVermelhoValor() {
		return sinalizadorVermelhoValor;
	}
	public void setSinalizadorVermelhoValor(double sinalizadorVermelhoValor) {
		this.sinalizadorVermelhoValor = sinalizadorVermelhoValor;
	}
	public String getSinalizadorAmareloSinal() {
		return sinalizadorAmareloSinal;
	}
	public void setSinalizadorAmareloSinal(String sinalizadorAmareloSinal) {
		this.sinalizadorAmareloSinal = sinalizadorAmareloSinal;
	}
	public double getSinalizadorAmareloValor() {
		return sinalizadorAmareloValor;
	}
	public void setSinalizadorAmareloValor(double sinalizadorAmareloValor) {
		this.sinalizadorAmareloValor = sinalizadorAmareloValor;
	}
	public String getSinalizadorVerdeSinal() {
		return sinalizadorVerdeSinal;
	}
	public void setSinalizadorVerdeSinal(String sinalizadorVerdeSinal) {
		this.sinalizadorVerdeSinal = sinalizadorVerdeSinal;
	}
	public double getSinalizadorVerdeValor() {
		return sinalizadorVerdeValor;
	}
	public void setSinalizadorVerdeValor(double sinalizadorVerdeValor) {
		this.sinalizadorVerdeValor = sinalizadorVerdeValor;
	}
	
	
	
}
