package br.com.semear.gestao.model;

import java.util.List;

public class UnidadePrisional {
	
	private long id;

	private String nome;

	private boolean status;

	private List<Reeducando> reeducandos;

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

	public List<Reeducando> getReeducandos() {
		return reeducandos;
	}

	public void setReeducandos(List<Reeducando> reeducandos) {
		this.reeducandos = reeducandos;
	}
}