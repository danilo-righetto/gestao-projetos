package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParticipacaoAcaoEntity;
import br.com.semear.gestao.model.ParticipacaoAcao;

public interface ParticipacaoAcaoService {
	public void cadastrar(ParticipacaoAcao participacaoAcao);

	public List<ParticipacaoAcaoEntity> listarParticipacaoAcoes();
}