package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.ParticipacaoParceiroProjeto;

public interface ParticipacaoParceiroProjetoService {

	public void cadastrarParticipacaoParceiro(ParticipacaoParceiroProjeto participacaoParceiroProjeto);

	public List<ParticipacaoParceiroProjeto> listarParticipacaoParceirosProjeto(long idProjeto);

	public List<Long> buscarParceirosAssociados(long idProjeto);
}