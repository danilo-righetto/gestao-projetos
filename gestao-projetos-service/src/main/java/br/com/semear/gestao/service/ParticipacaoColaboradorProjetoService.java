package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.ParticipacaoColaboradorProjeto;
import br.com.semear.gestao.model.Usuario;

public interface ParticipacaoColaboradorProjetoService {
	public void cadastrar(ParticipacaoColaboradorProjeto colaboradorProjeto);

	public List<ParticipacaoColaboradorProjeto> listarParticipacaoProjetos(long idProjeto);

	public List<Usuario> buscarColaboradoresAssociados(Long idProjeto);

}