package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParticipacaoAcaoEntity;

public interface ParticipacaoAcaoDAO {
	public void cadastrar(ParticipacaoAcaoEntity participacaoAcao);
	
	public List<ParticipacaoAcaoEntity> listarParticipacaoAcoes();
}
