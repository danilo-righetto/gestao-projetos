package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.UnidadePrisionalDAO;
import br.com.semear.gestao.dao.entity.ParceiroEntity;
import br.com.semear.gestao.dao.entity.UnidadePrisionalEntity;
import br.com.semear.gestao.dao.entity.UnidadeRelParceiroEntity;
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
	public void editar(UnidadePrisional unidadePrisional) {
		unidadePrisionalDAO.editar(parse.parseToEntity(unidadePrisional));
	}

	@Override
	public void excluir(UnidadePrisional unidadePrisional) {
		unidadePrisionalDAO.excluir(parse.parseToEntity(unidadePrisional));
	}

	@Override
	public List<UnidadePrisional> listaUnidades() {
		List<UnidadePrisionalEntity> lista = unidadePrisionalDAO.listarUnidades();
		List<UnidadePrisional> unidadesPrisionais = new ArrayList<UnidadePrisional>();
		for (UnidadePrisionalEntity u : lista) {
			unidadesPrisionais.add(parse.parseToModel(u));
		}
		return unidadesPrisionais;
	}

	@Override
	public UnidadePrisional buscarUnidadePrisionalPorId(long idUnidadePrisional) {
		return parse.parseToModel(unidadePrisionalDAO.buscarUnidadePrisionalPorId(idUnidadePrisional));
	}

	@Override
	public List<UnidadePrisional> buscarUnidadePrisionalPorParceiro(long idParceiro) {
		List<UnidadePrisionalEntity> lista = unidadePrisionalDAO.buscarUnidadePrisionalPorParceiro(idParceiro);
		List<UnidadePrisional> unidadesPrisionais = new ArrayList<UnidadePrisional>();
		for (UnidadePrisionalEntity u : lista) {
			unidadesPrisionais.add(parse.parseToModel(u));
		}
		return unidadesPrisionais;
	}

	@Override
	public List<UnidadePrisional> listarUnidadesPorStatus(boolean status) {
		List<UnidadePrisionalEntity> lista = unidadePrisionalDAO.listarUnidadesPorStatus(status);
		List<UnidadePrisional> unidadesPrisionais = new ArrayList<UnidadePrisional>();
		for (UnidadePrisionalEntity u : lista) {
			unidadesPrisionais.add(parse.parseToModel(u));
		}
		return unidadesPrisionais;
	}

	@Override
	public void adicionarVinculoParceiroComUnidadePrisional(long idParceiro, long idUnidadePrisional) {
		UnidadeRelParceiroEntity rel = new UnidadeRelParceiroEntity();
		rel.setParceiro(new ParceiroEntity(idParceiro));
		rel.setUnidadePrisional(new UnidadePrisionalEntity(idUnidadePrisional));
		rel.setDataEntrada(Calendar.getInstance());
		unidadePrisionalDAO.adicionarVinculoParceiroComUnidadePrisional(rel);
		
	}
}