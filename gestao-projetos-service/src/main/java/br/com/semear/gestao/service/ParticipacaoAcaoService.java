package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParticipacaoReeducandoAcaoEntity;
import br.com.semear.gestao.model.ParticipacaoReeducandoAcao;

public interface ParticipacaoAcaoService {
	public void cadastrar(ParticipacaoReeducandoAcao participacaoAcao);

	public List<ParticipacaoReeducandoAcaoEntity> listarParticipacaoAcoes();
}