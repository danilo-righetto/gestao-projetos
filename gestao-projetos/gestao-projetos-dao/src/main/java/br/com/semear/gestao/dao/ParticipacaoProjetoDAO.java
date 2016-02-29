package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParticipacaoProjetoEntity;

public interface ParticipacaoProjetoDAO {
	public void cadastrar(ParticipacaoProjetoEntity participacaoProjeto);

	public List<ParticipacaoProjetoEntity> listarParticipacaoProjetos();
}