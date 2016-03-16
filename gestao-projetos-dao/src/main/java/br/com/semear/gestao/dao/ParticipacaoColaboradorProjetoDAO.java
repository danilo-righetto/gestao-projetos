package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParticipacaoColaboradorProjetoEntity;

public interface ParticipacaoColaboradorProjetoDAO {
	public void cadastrar(ParticipacaoColaboradorProjetoEntity entity);

	public List<ParticipacaoColaboradorProjetoEntity> listarParticipacaoProjetos(long idProjeto);
}
