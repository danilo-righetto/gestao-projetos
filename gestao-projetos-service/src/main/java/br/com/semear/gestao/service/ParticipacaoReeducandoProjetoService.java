package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.ParticipacaoReeducandoProjeto;
import br.com.semear.gestao.model.Usuario;

public interface ParticipacaoReeducandoProjetoService {
	public void cadastrar(ParticipacaoReeducandoProjeto participacaoReeducandoProjeto);

	public List<ParticipacaoReeducandoProjeto> listarParticipacaoProjetos(long idProjeto);

	public List<ParticipacaoReeducandoProjeto> listarParticipacaoProjetos();

	public List<Usuario> buscarReeducandosAssociados(Long idProjeto);
}