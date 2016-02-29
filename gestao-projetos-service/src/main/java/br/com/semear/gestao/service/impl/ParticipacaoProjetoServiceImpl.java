package br.com.semear.gestao.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoProjetoEntity;
import br.com.semear.gestao.model.ParticipacaoProjeto;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.ParticipacaoProjetoService;
import br.com.semear.gestao.service.ProjetoService;
import br.com.semear.gestao.service.ReeducandoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ParticipacaoProjetoServiceImpl implements ParticipacaoProjetoService{
	
	@Inject
	private ParticipacaoProjetoDAO participacaoProjetoDAO;
	
	@Inject
	private ParseService parse;
	
	@Inject
	private ProjetoService projetoService;
	
	@Inject
	private ReeducandoService reeducandoService;
	
	@Override
	public void cadastrar(ParticipacaoProjeto participacaoProjeto) {
		participacaoProjeto.setReeducando(reeducandoService.buscarReeducandoPorId(participacaoProjeto.getReeducando().getId()));
		participacaoProjeto.setProjeto(projetoService.buscarProjetoPorNome(participacaoProjeto.getProjeto().getNome()));
		participacaoProjetoDAO.cadastrar(parse.parseToEntity(participacaoProjeto));
	}

	@Override
	public List<ParticipacaoProjetoEntity> listarParticipacaoProjetos() {
		return participacaoProjetoDAO.listarParticipacaoProjetos();
	}
}