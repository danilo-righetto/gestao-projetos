package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Instituicao;

public interface InstituicaoService {
	public String cadastrarInstituicao(Instituicao instituicao);
	
	public List<Instituicao> listarInstituicoes();
	
	public Instituicao buscarInstituicaoPorId(Long idInstituicao);

	public void editarInstituicao(Instituicao instituicao);
	
	public Instituicao buscarInstituicaoPorDocumento(String documento);
	
	public long buscarUnidadePrisionalPorInstituicao(long idInstituicao);

	public List<Instituicao> buscarInstituicaoPorUnidade(long idUnidadePrisional);

	public List<Instituicao> buscarInstituicoesPorId(Long[] idInstituicoes);

	public long buscarUnidadePrisionalPorProjeto(long idProjeto);
}