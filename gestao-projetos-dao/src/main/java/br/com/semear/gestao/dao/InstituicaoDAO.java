package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.InstituicaoEntity;

public interface InstituicaoDAO {
	public long cadastrarInstituicao(InstituicaoEntity instituicao);
	
	public List<InstituicaoEntity> listarInstituicoes();

	public void editarInstituicao(InstituicaoEntity instituicao);

	public InstituicaoEntity buscarInstituicaoPorId(long idInstituicao);
	
	public InstituicaoEntity buscarInstituicaoPorDocumento(String documento);
}
