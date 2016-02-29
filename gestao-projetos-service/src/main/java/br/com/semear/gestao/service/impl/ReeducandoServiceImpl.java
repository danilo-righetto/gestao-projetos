package br.com.semear.gestao.service.impl;

import java.util.Calendar;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ReeducandoDAO;
import br.com.semear.gestao.model.Reeducando;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.ReeducandoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ReeducandoServiceImpl implements ReeducandoService {

	@Inject
	private ReeducandoDAO reeducandoDAO;

	@Inject
	private ParseService parse;
	
	@Override
	public void cadastrarReeducando(Reeducando reeducando) {
		reeducando.setDataCadastro(Calendar.getInstance());
		reeducandoDAO.cadastrarReeducando(parse.parseToEntity(reeducando));
	}

	@Override
	public Reeducando buscarReeducandoPorId(long idReeducando) {
		return parse.parseToModel(reeducandoDAO.buscarReeducandoPorId(idReeducando));
	}
}