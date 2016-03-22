package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ProjetoDAO;
import br.com.semear.gestao.dao.entity.AcaoEntity;
import br.com.semear.gestao.dao.entity.AcaoRelProjetoEntity;
import br.com.semear.gestao.dao.entity.InstituicaoEntity;
import br.com.semear.gestao.dao.entity.ProjetoEntity;
import br.com.semear.gestao.dao.entity.UsuarioEntity;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.ProjetoService;
import br.com.semear.gestao.service.QuestionarioService;
import br.com.semear.gestao.service.UsuarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProjetoServiceImpl implements ProjetoService {

	@Inject
	private ProjetoDAO projetoDAO;

	@Inject
	private ParseService parseService;
	
	@SuppressWarnings("unused")
	@Inject
	private QuestionarioService questionarioService;
	
	@Inject
	private UsuarioService usuarioService;

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
			projeto.setCoordenador(usuarioService.buscarUsuarioPorId(projeto.getCoordenador().getId()));
			entity.setCoordenador(parseService.parseToEntity(projeto.getCoordenador()));
		}
		projetoDAO.editarProjeto(entity);
	}

	@Override
	public long buscarUnidadePrisionalDoProjeto(long idProjeto) {
		return projetoDAO.buscarUnidadePrisionalDoProjeto(idProjeto);
	}

	@Override
	public Usuario buscarCoodernadorPorIdProjeto(long idProjeto) {
		UsuarioEntity entity = projetoDAO.buscarCoodernadorPorIdProjeto(idProjeto);
		InstituicaoEntity instEntity = projetoDAO.buscarInstituicaoDoCoodernadorPorIdProjeto(idProjeto);
		if(entity != null){
			Usuario coodernador = parseService.parseToModel(entity);
			coodernador.setInstituicao(parseService.parseToModel(instEntity));
			return coodernador;
		}else{
			return null;
		}
	}

	@Override
	public void adicionarVinculoAcaoComProjeto(long idAcao, long idProjeto) {
		AcaoRelProjetoEntity rel = new AcaoRelProjetoEntity();
		rel.setAcao(new AcaoEntity(idAcao));
		rel.setProjeto(new ProjetoEntity(idProjeto));
		rel.setDataEntrada(Calendar.getInstance());
		projetoDAO.adicionarVinculoAcaoComProjeto(rel);
	}

}