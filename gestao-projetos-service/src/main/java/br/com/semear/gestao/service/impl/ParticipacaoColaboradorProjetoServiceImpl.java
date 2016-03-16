package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoColaboradorProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoColaboradorProjetoEntity;
import br.com.semear.gestao.model.ParticipacaoColaboradorProjeto;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.ParticipacaoColaboradorProjetoService;
import br.com.semear.gestao.service.UsuarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ParticipacaoColaboradorProjetoServiceImpl implements ParticipacaoColaboradorProjetoService {

	@Inject
	private ParticipacaoColaboradorProjetoDAO participacaoColaboradorProjetoDao;
	
	@Inject
	private ParseService parse;
	
	@Inject
	private UsuarioService usuarioService;
	
	@Override
	public void cadastrar(ParticipacaoColaboradorProjeto participacaoColaboradorProjeto) {
		participacaoColaboradorProjeto.setColaborador((usuarioService.buscarUsuarioPorId(participacaoColaboradorProjeto.getColaborador().getId())));
		participacaoColaboradorProjetoDao.cadastrar(parse.parseToEntity(participacaoColaboradorProjeto));
	}

	@Override
	public List<ParticipacaoColaboradorProjeto> listarParticipacaoProjetos(long idProjeto) {
		List<ParticipacaoColaboradorProjetoEntity> entitys = participacaoColaboradorProjetoDao.listarParticipacaoProjetos(idProjeto);
		List<ParticipacaoColaboradorProjeto> colaboradores = new ArrayList<ParticipacaoColaboradorProjeto>();
		for(ParticipacaoColaboradorProjetoEntity p : entitys){
			colaboradores.add(parse.parseToModel(p));
		}
		return colaboradores;
	}
}
