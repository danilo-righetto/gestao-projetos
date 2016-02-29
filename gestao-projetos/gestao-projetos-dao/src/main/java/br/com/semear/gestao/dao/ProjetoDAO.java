package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.ProjetoEntity;

public interface ProjetoDAO {
	public void cadastrarProjeto(ProjetoEntity projeto);

	List<ProjetoEntity> listarTodosProjetos();

	ProjetoEntity buscarProjetoPorNome(String nome);
}