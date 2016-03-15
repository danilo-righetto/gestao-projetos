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
import br.com.semear.gestao.service.QuestionarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProjetoServiceImpl implements ProjetoService {

	@Inject
	private ProjetoDAO projetoDAO;

	@Inject
	private ParseService parseService;
	
	@Inject
	private QuestionarioService questionarioService;

	@Override
	public String cadastrarProjeto(Projeto novoProjeto) {
		novoProjeto.setDataCadastro(Calendar.getInstance());
		ProjetoEntity projetoEntity = parseService.parseToEntity(novoProjeto);
		novoProjeto.setId(projetoDAO.cadastrarProjeto(projetoEntity));
		if(novoProjeto.getId() > 0){
			return "OK";
		}
		return "NOK";
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

	@Override
	public Projeto buscarProjetoPorId(long idProjeto) {
		return parseService.parseToModel(projetoDAO.buscarProjetoPorId(idProjeto));
	}

	@Override
	public void editarProjeto(Projeto projeto) {
		ProjetoEntity entity = projetoDAO.buscarProjetoPorId(projeto.getId());
		entity.setDataInicio(projeto.getDataInicio());
		entity.setDataTermino(projeto.getDataTermino());
		entity.setDescricao(projeto.getDescricao());
		entity.setNome(projeto.getNome());
		entity.setStatus(projeto.getStatus());
		if(projeto.getCoordenador() != null && projeto.getCoordenador().getId() > 0){
			entity.setCoordenador(parseService.parseToEntity(projeto.getCoordenador()));
		}
		projetoDAO.editarProjeto(entity);
	}

}