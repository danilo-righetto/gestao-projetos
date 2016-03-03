package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.Instituicao;

public interface InstituicaoService {
	public void cadastrarInstituicao(Instituicao instituicao);
	
	public List<Instituicao> listarInstituicoes();
	
	public Instituicao buscarInstituicaoPorId(long idInstituicao);

	public void editarInstituicao(Instituicao instituicao);

}
