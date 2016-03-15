package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.ParticipacaoInstituicaoProjeto;

public interface ParticipacaoInstituicaoProjetoService {

	public void cadastrarParticipacaoInstituicao(ParticipacaoInstituicaoProjeto participacaoInstituicaoProjeto);

	public List<ParticipacaoInstituicaoProjeto> listarParticipacaoInstituicoesProjeto(long idProjeto);

	public List<Long> buscarInstituicoesAssociadas(long idProjeto);
}