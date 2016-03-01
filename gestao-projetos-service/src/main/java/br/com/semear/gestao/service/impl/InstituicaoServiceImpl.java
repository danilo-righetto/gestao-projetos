package br.com.semear.gestao.service.impl;

import java.util.Calendar;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.InstituicaoDAO;
import br.com.semear.gestao.model.Instituicao;
import br.com.semear.gestao.service.InstituicaoService;
import br.com.semear.gestao.service.ParseService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class InstituicaoServiceImpl implements InstituicaoService{
	
	@Inject
	private InstituicaoDAO instituicaoDAO;
	
	@Inject
	private ParseService parse;

	@Override
	public void cadastrarInstituicao(Instituicao instituicao) {
		instituicao.setDataCadastro(Calendar.getInstance());
		instituicaoDAO.cadastrarInstituicao(parse.parseToEntity(instituicao));
	}

}
