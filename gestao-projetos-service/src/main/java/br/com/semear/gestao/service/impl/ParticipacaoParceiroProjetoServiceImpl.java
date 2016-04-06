package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoParceiroProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoParceiroProjetoEntity;
import br.com.semear.gestao.model.Parceiro;
import br.com.semear.gestao.model.ParticipacaoParceiroProjeto;
import br.com.semear.gestao.model.Projeto;
import br.com.semear.gestao.service.ParceiroService;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.ParticipacaoParceiroProjetoService;
import br.com.semear.gestao.service.ProjetoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ParticipacaoParceiroProjetoServiceImpl implements ParticipacaoParceiroProjetoService {

	@Inject
	private ParticipacaoParceiroProjetoDAO participacaoParceiroProjetoDAO;

	@Inject
	private ProjetoService projetoService;

	@Inject
	private ParceiroService parceiroService;

	@Inject
	private ParseService parse;

	@Override
	public void cadastrarParticipacaoParceiro(ParticipacaoParceiroProjeto participacaoParceiroProjeto) {
		Projeto projeto = projetoService.buscarProjetoPorId(participacaoParceiroProjeto.getProjeto().getId());
		Parceiro parceiro = parceiroService
				.buscarParceiroPorId(participacaoParceiroProjeto.getParceiro().getId());

		participacaoParceiroProjeto.setProjeto(projeto);
		participacaoParceiroProjeto.setParceiro(parceiro);

		participacaoParceiroProjetoDAO
				.cadastrarParticipacaoParceiro(parse.parseToEntity(participacaoParceiroProjeto));
	}

	@Override
	public List<ParticipacaoParceiroProjeto> listarParticipacaoParceirosProjeto(long idProjeto) {
		List<ParticipacaoParceiroProjetoEntity> lista = participacaoParceiroProjetoDAO.listarParticipacaoParceirosProjeto(idProjeto);
		List<ParticipacaoParceiroProjeto> participacaoParceiroProjeto = new ArrayList<ParticipacaoParceiroProjeto>();
		for(ParticipacaoParceiroProjetoEntity p : lista){
			participacaoParceiroProjeto.add(parse.parseToModel(p));
		}
		return participacaoParceiroProjeto;
	}

	@Override
	public List<Long> buscarParceirosAssociados(long idProjeto) {
		List<Long> parceirosAssociadas = participacaoParceiroProjetoDAO.buscarParceirosAssociados(idProjeto);
		return parceirosAssociadas;
	}
}