package br.com.semear.gestao.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.AcaoDAO;
import br.com.semear.gestao.dao.entity.AcaoEntity;
import br.com.semear.gestao.model.Acao;
import br.com.semear.gestao.service.AcaoService;
import br.com.semear.gestao.service.ParseService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AcaoServiceImpl implements AcaoService{
	
	@Inject
	private AcaoDAO acaoDAO;
	
	@Inject
	private ParseService parse;

	@Override
	public void cadastrar(Acao acao) {
		acaoDAO.cadastrar(parse.parseToEntity(acao));
	}

	@Override
	public List<AcaoEntity> listarAcoes() {
		return acaoDAO.listarAcoes();
	}

}
