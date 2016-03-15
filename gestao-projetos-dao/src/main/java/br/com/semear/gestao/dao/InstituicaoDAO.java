package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.InstituicaoEntity;

public interface InstituicaoDAO {
	public long cadastrarInstituicao(InstituicaoEntity instituicao);
	
	public List<InstituicaoEntity> listarInstituicoes();

	public void editarInstituicao(InstituicaoEntity instituicao);

	public InstituicaoEntity buscarInstituicaoPorId(Long idInstituicao);
	
	public InstituicaoEntity buscarInstituicaoPorDocumento(String documento);

	public long buscarUnidadePrisionalPorInstituicao(long idInstituicao);

	public List<InstituicaoEntity> buscarInstituicaoPorUnidade(long idUnidadePrisional);

	public List<InstituicaoEntity> buscarInstituicaoPorId(Long[] idInstituicoes);
}