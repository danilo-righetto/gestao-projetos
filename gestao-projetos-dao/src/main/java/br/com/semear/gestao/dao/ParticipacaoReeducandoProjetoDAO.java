package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParticipacaoReeducandoProjetoEntity;
import br.com.semear.gestao.dao.entity.UsuarioEntity;

public interface ParticipacaoReeducandoProjetoDAO {
	public void cadastrar(ParticipacaoReeducandoProjetoEntity participacaoProjeto);

	public List<ParticipacaoReeducandoProjetoEntity> listarParticipacaoProjetos();

	public List<ParticipacaoReeducandoProjetoEntity> listarParticipacaoProjetos(long idProjeto);

	public List<UsuarioEntity> buscarReeducandosAssociados(long idProjeto);
}