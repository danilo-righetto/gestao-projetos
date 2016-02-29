package br.com.semear.gestao.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoAcaoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoAcaoEntity;
import br.com.semear.gestao.model.ParticipacaoAcao;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.ParticipacaoAcaoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ParticipacaoAcaoServiceImpl implements ParticipacaoAcaoService {

	@Inject
	private ParticipacaoAcaoDAO participacaoAcaoDAO;
	
	@Inject
	private ParseService parse;

	@Override
	public void cadastrar(ParticipacaoAcao participacaoAcao) {
		participacaoAcaoDAO.cadastrar(parse.parseToEntity(participacaoAcao));
	}

	@Override
	public List<ParticipacaoAcaoEntity> listarParticipacaoAcoes() {
		return participacaoAcaoDAO.listarParticipacaoAcoes();
	}

}
