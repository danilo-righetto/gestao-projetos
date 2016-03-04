package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ReeducandoDAO;
import br.com.semear.gestao.dao.entity.ReeducandoEntity;
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
	public void editarReeducando(Reeducando reeducando) {
		ReeducandoEntity entity = reeducandoDAO.buscarReeducandoPorId(reeducando.getId());
		entity.setNome(reeducando.getNome());
		entity.setSexo(reeducando.getSexo());
		entity.setDataNascimento(reeducando.getDataNascimento());
		reeducandoDAO.editarReeducando(entity);
	}

	@Override
	public List<Reeducando> listarReeducandos() {
		List<ReeducandoEntity> lista = reeducandoDAO.listarReeducandos();
		List<Reeducando> reeducando = new ArrayList<Reeducando>();
		for (ReeducandoEntity reeducandoEn : lista) {
			reeducando.add(parse.parseToModel(reeducandoEn));
		}
		return reeducando;
	}

	@Override
	public Reeducando buscarReeducandoPorId(long idReeducando) {
		return parse.parseToModel(reeducandoDAO.buscarReeducandoPorId(idReeducando));
	}

	@Override
	public boolean verficarMatricula(long matricula) {
		boolean existe = false;
		if (reeducandoDAO.buscarMatricula(matricula) != null) {
			existe = true;
		}
		return existe;
	}
}