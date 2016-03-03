package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.InstituicaoEntity;

public interface InstituicaoDAO {
	public void cadastrarInstituicao(InstituicaoEntity instituicao);
	
	public List<InstituicaoEntity> listarInstituicoes();

	public void editarInstituicao(InstituicaoEntity instituicao);

	public InstituicaoEntity buscarInstituicaoPorId(long idInstituicao);
}
