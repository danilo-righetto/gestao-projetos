package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Projeto;

public interface ProjetoService {
	public void cadastrarProjeto(Projeto projeto);

	List<Projeto> listarTodosProjetos();

	Projeto buscarProjetoPorNome(String nome);

	public Projeto buscarProjetoPorId(long idProjeto);

	public void editarProjeto(Projeto projeto);

}