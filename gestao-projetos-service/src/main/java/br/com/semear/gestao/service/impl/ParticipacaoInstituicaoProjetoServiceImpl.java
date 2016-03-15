package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoInstituicaoProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoInstituicaoProjetoEntity;
import br.com.semear.gestao.model.Instituicao;
import br.com.semear.gestao.model.ParticipacaoInstituicaoProjeto;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.service.InstituicaoService;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.ParticipacaoInstituicaoProjetoService;
import br.com.semear.gestao.service.ProjetoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ParticipacaoInstituicaoProjetoServiceImpl implements ParticipacaoInstituicaoProjetoService {

	@Inject
	private ParticipacaoInstituicaoProjetoDAO participacaoInstituicaoProjetoDAO;

	@Inject
	private ProjetoService projetoService;

	@Inject
	private InstituicaoService instituicaoService;

	@Inject
	private ParseService parse;

	@Override
	public void cadastrarParticipacaoInstituicao(ParticipacaoInstituicaoProjeto participacaoInstituicaoProjeto) {
		Projeto projeto = projetoService.buscarProjetoPorId(participacaoInstituicaoProjeto.getProjeto().getId());
		Instituicao instituicao = instituicaoService
				.buscarInstituicaoPorId(participacaoInstituicaoProjeto.getInstituicao().getId());

		participacaoInstituicaoProjeto.setProjeto(projeto);
		participacaoInstituicaoProjeto.setInstituicao(instituicao);

		participacaoInstituicaoProjetoDAO
				.cadastrarParticipacaoInstituicao(parse.parseToEntity(participacaoInstituicaoProjeto));
	}

	@Override
	public List<ParticipacaoInstituicaoProjeto> listarParticipacaoInstituicoesProjeto(long idProjeto) {
		List<ParticipacaoInstituicaoProjetoEntity> lista = participacaoInstituicaoProjetoDAO.listarParticipacaoInstituicoesProjeto(idProjeto);
		List<ParticipacaoInstituicaoProjeto> participacaoInstituicaoProjeto = new ArrayList<ParticipacaoInstituicaoProjeto>();
		for(ParticipacaoInstituicaoProjetoEntity p : lista){
			participacaoInstituicaoProjeto.add(parse.parseToModel(p));
		}
		return participacaoInstituicaoProjeto;
	}

	@Override
	public List<Long> buscarInstituicoesAssociadas(long idProjeto) {
		List<Long> instituicoesAssociadas = participacaoInstituicaoProjetoDAO.buscarInstituicoesAssociadas(idProjeto);
		return instituicoesAssociadas;
	}
}