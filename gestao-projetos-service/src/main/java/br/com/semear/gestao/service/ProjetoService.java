package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Usuario;

public interface ProjetoService {
	public String cadastrarProjeto(Projeto projeto);

	List<Projeto> listarTodosProjetos();

	Projeto buscarProjetoPorNome(String nome);

	public Projeto buscarProjetoPorId(long idProjeto);

	public void editarProjeto(Projeto projeto);
	
	public long buscarUnidadePrisionalDoProjeto(long idProjeto);

	public Usuario buscarCoodernadorPorIdProjeto(long idProjeto);
	
	public void adicionarVinculoAcaoComProjeto(long idAcao, long idProjeto);
}