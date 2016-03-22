package br.com.semear.gestao.model;

public class ParticipacaoUsuarioProjeto {
	
	private long id;
	
	private Usuario usuario;
	
	private Projeto projeto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
}