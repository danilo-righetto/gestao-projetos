package br.com.semear.gestao.dao;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParticipacaoReeducandoAcaoEntity;

public interface ParticipacaoAcaoDAO {
	public void cadastrar(ParticipacaoReeducandoAcaoEntity participacaoAcao);
	
	public List<ParticipacaoReeducandoAcaoEntity> listarParticipacaoAcoes();
}
