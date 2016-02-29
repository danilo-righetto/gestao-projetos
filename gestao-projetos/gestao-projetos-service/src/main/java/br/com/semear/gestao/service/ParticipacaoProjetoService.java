package br.com.semear.gestao.service;

import java.util.List;

import br.com.semear.gestao.dao.entity.ParticipacaoProjetoEntity;
import br.com.semear.gestao.model.ParticipacaoProjeto;

public interface ParticipacaoProjetoService {
	public void cadastrar(ParticipacaoProjeto participacaoProjeto);
	
	public List<ParticipacaoProjetoEntity> listarParticipacaoProjetos();
}