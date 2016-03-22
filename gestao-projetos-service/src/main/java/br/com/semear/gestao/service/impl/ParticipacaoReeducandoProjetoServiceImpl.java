package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoReeducandoProjetoDAO;
import br.com.semear.gestao.dao.entity.ParticipacaoReeducandoProjetoEntity;
import br.com.semear.gestao.dao.entity.UsuarioEntity;
import br.com.semear.gestao.model.ParticipacaoReeducandoProjeto;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.ParticipacaoReeducandoProjetoService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ParticipacaoReeducandoProjetoServiceImpl implements ParticipacaoReeducandoProjetoService {

	@Inject
	private ParticipacaoReeducandoProjetoDAO participacaoReeducandoProjetoDAO;

	@Inject
	private ParseService parse;

	@Override
	public void cadastrar(ParticipacaoReeducandoProjeto participacaoReeducandoProjeto) {
		participacaoReeducandoProjetoDAO.cadastrar(parse.parseToEntity(participacaoReeducandoProjeto));
	}

	@Override
	public List<ParticipacaoReeducandoProjeto> listarParticipacaoProjetos() {
		List<ParticipacaoReeducandoProjetoEntity> entitys = participacaoReeducandoProjetoDAO
				.listarParticipacaoProjetos();
		List<ParticipacaoReeducandoProjeto> reeducandos = new ArrayList<ParticipacaoReeducandoProjeto>();
		for (ParticipacaoReeducandoProjetoEntity p : entitys) {
			reeducandos.add(parse.parseToModel(p));
		}
		return reeducandos;
	}

	@Override
	public List<ParticipacaoReeducandoProjeto> listarParticipacaoProjetos(long idProjeto) {
		List<ParticipacaoReeducandoProjetoEntity> entitys = participacaoReeducandoProjetoDAO
				.listarParticipacaoProjetos(idProjeto);
		List<ParticipacaoReeducandoProjeto> reeducandos = new ArrayList<ParticipacaoReeducandoProjeto>();
		for (ParticipacaoReeducandoProjetoEntity p : entitys) {
			reeducandos.add(parse.parseToModel(p));
		}
		return reeducandos;
	}

	@Override
	public List<Usuario> buscarReeducandosAssociados(Long idProjeto) {
		List<UsuarioEntity> entitys = participacaoReeducandoProjetoDAO.buscarReeducandosAssociados(idProjeto);
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for (UsuarioEntity usuario : entitys) {
			usuarios.add(parse.parseToModel(usuario));
		}
		return usuarios;
	}
}