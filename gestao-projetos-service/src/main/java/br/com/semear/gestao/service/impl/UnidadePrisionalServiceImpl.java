package br.com.semear.gestao.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.UnidadePrisionalDAO;
import br.com.semear.gestao.dao.entity.UnidadePrisionalEntity;
import br.com.semear.gestao.model.UnidadePrisional;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.UnidadePrisionalService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UnidadePrisionalServiceImpl implements UnidadePrisionalService {

	@Inject
	private UnidadePrisionalDAO unidadePrisionalDAO;
	
	@Inject
	private ParseService parse;

	@Override
	public void cadastrar(UnidadePrisional unidadePrisional) {
		unidadePrisionalDAO.cadastrar(parse.parseToEntity(unidadePrisional));
	}

	@Override
	public List<UnidadePrisionalEntity> listaUnidades() {
		return unidadePrisionalDAO.listarUnidades();
	}
}