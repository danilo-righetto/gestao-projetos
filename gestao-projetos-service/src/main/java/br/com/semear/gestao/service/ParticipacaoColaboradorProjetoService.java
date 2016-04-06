package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.model.ParticipacaoColaboradorProjeto;
import br.com.semear.gestao.model.Usuario;

public interface ParticipacaoColaboradorProjetoService {
	public void cadastrar(ParticipacaoColaboradorProjeto colaboradorProjeto);

	public List<Usuario> listarColaboradoresDoProjeto(long idProjeto, String idPerfil);

	public List<Usuario> listarAssociadosDoProjeto(Long idProjeto);
}