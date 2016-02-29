package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ProjetoDAO;
import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.ProjetoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProjetoServiceImpl implements ProjetoService {

	@Inject
	private ProjetoDAO projetoDAO;

	@Inject
	private ParseService parseService;

	@Override
	public void cadastrarProjeto(Projeto projeto) {
		projeto.setDataCadastro(Calendar.getInstance());

		projetoDAO.cadastrarProjeto(parseService.parseToEntity(projeto));
	}

	@Override
	public List<Projeto> listarTodosProjetos() {
		List<ProjetoEntity> lista = projetoDAO.listarTodosProjetos();
		List<Projeto> projetos = new ArrayList<Projeto>();
		for(ProjetoEntity p : lista){
			projetos.add(parseService.parseToModel(p));
		}
		return projetos;
	}
	
	@Override
	public Projeto buscarProjetoPorNome(String nome){
		return parseService.parseToModel(projetoDAO.buscarProjetoPorNome(nome));
	}

}
