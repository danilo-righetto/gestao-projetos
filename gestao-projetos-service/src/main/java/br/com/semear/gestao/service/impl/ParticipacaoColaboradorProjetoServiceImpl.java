package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ParticipacaoColaboradorProjetoDAO;
import br.com.semear.gestao.dao.entity.UsuarioEntity;
import br.com.semear.gestao.model.ParticipacaoColaboradorProjeto;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.ParticipacaoColaboradorProjetoService;
import br.com.semear.gestao.service.ParticipacaoReeducandoProjetoService;
import br.com.semear.gestao.service.UsuarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ParticipacaoColaboradorProjetoServiceImpl implements ParticipacaoColaboradorProjetoService {

	@Inject
	private ParticipacaoColaboradorProjetoDAO participacaoColaboradorProjetoDao;

	@Inject
	private ParticipacaoReeducandoProjetoService participacaoReeducandoProjetoService;

	@Inject
	private ParseService parse;

	@Inject
	private UsuarioService usuarioService;

	@Override
	public void cadastrar(ParticipacaoColaboradorProjeto participacaoColaboradorProjeto) {
		participacaoColaboradorProjeto.setColaborador(
				(usuarioService.buscarUsuarioPorId(participacaoColaboradorProjeto.getColaborador().getId())));
		participacaoColaboradorProjetoDao.cadastrar(parse.parseToEntity(participacaoColaboradorProjeto));
	}

	@Override
	public List<Usuario> listarColaboradoresDoProjeto(long idProjeto, String idPerfil) {
		List<UsuarioEntity> lista = participacaoColaboradorProjetoDao.listarColaboradoresDoProjeto(idProjeto, idPerfil);
		List<Usuario> colaboradores = new ArrayList<Usuario>();
		for (UsuarioEntity c : lista) {
			colaboradores.add(parse.parseToModel(c));
		}
		return colaboradores;
	}

	@Override
	public List<Usuario> listarAssociadosDoProjeto(Long idProjeto) {
		List<UsuarioEntity> colaboradores = participacaoColaboradorProjetoDao.listarColaboradoresDoProjeto(idProjeto,
				"ROLE_COLABORADOR");
		List<Usuario> reeducandos = participacaoReeducandoProjetoService.buscarReeducandosAssociados(idProjeto);

		List<Usuario> usuarios = new ArrayList<Usuario>();
		for (UsuarioEntity usuario : colaboradores) {
			usuarios.add(parse.parseToModel(usuario));
		}
		usuarios.addAll(reeducandos);
		return usuarios;
	}
}