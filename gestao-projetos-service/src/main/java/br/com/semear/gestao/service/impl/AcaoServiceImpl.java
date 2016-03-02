package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
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
public class AcaoServiceImpl implements AcaoService {

	@Inject
	private AcaoDAO acaoDAO;

	@Inject
	private ParseService parse;

	@Override
	public void cadastrar(Acao acao) {
		acao.setDataCadastro(Calendar.getInstance());
		acaoDAO.cadastrar(parse.parseToEntity(acao));
	}

	@Override
	public void editar(Acao acao) {
		acaoDAO.editar(parse.parseToEntity(acao));
	}

	@Override
	public List<Acao> listarAcoes() {
		List<AcaoEntity> lista = acaoDAO.listarAcoes();
		List<Acao> acao = new ArrayList<Acao>();
		for (AcaoEntity a : lista) {
			acao.add(parse.parseToModel(a));
		}
		return acao;
	}

	@Override
	public Acao buscarAcaoPorId(long idAcao) {
		return parse.parseToModel(acaoDAO.buscarAcaoPorId(idAcao));
	}
}