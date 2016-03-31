package br.com.semear.gestao.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.semear.gestao.dao.ColaboradorDAO;
import br.com.semear.gestao.dao.entity.ColaboradorEntity;
import br.com.semear.gestao.model.Colaborador;
import br.com.semear.gestao.model.Parceiro;
import br.com.semear.gestao.model.Usuario;
import br.com.semear.gestao.service.ColaboradorService;
import br.com.semear.gestao.service.ParceiroService;
import br.com.semear.gestao.service.MailService;
import br.com.semear.gestao.service.ParseService;
import br.com.semear.gestao.service.UsuarioService;
import br.com.semear.gestao.service.UtilService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ColaboradorServiceImpl implements ColaboradorService {

	@Inject
	private PasswordEncoder passwordEncoder;

	@Inject
	private ParseService parse;

	@Inject
	private UtilService util;

	@Inject
	private MailService mailService;

	@Inject
	private ColaboradorDAO colaboradorDAO;

	@Inject
	private ParceiroService parceiroService;

	@Inject
	private UsuarioService usuarioService;

	@Override
	public void cadastrar(Colaborador colaborador) {
		String senha = util.gerarSenha();
		Parceiro parceiro = parceiroService.buscarParceiroPorId(colaborador.getParceiro().getId());
		Usuario usuario = new Usuario();
		usuario.setNome(colaborador.getNome());
		usuario.setUsuario(colaborador.getEmail());
		usuario.setPerfil(colaborador.getUsuario().getPerfil());
		usuario.setParceiro(parceiro);
		usuario.setRealizaLogin(true);
		usuario.setDataCadastro(Calendar.getInstance());

		usuario.setSenha(passwordEncoder.encode(senha));
		colaborador.setUsuario(usuario);
		colaborador.setParceiro(parceiro);
		colaboradorDAO.cadastrar(parse.parseToEntity(colaborador));
		mailService.enviarEmailSenhaCriada(colaborador.getEmail(), senha);
	}

	@Override
	public void editar(Colaborador colaborador) {
		Usuario usuario = usuarioService.buscarUsuarioPorId(colaborador.getUsuario().getId());
		Parceiro parceiro = parceiroService.buscarParceiroPorId(colaborador.getParceiro().getId());

		usuario.setNome(colaborador.getNome());
		usuario.setUsuario(colaborador.getEmail());
		usuario.setPerfil(colaborador.getUsuario().getPerfil());
		colaborador.setUsuario(usuario);
		colaborador.setParceiro(parceiro);
		colaboradorDAO.editar(parse.parseToEntity(colaborador));
	}

	@Override
	public List<Colaborador> listarColaboradores(long idParceiro) {
		List<ColaboradorEntity> lista = colaboradorDAO.listarColaboradores(idParceiro);
		List<Colaborador> colaboradores = new ArrayList<Colaborador>();
		for (ColaboradorEntity colaborador : lista) {
			colaboradores.add(parse.parseToModel(colaborador));
		}
		return colaboradores;
	}

	@Override
	public Colaborador buscarColaboradorPorId(long idColaborador) {
		return parse.parseToModel(colaboradorDAO.buscarColaboradorPorId(idColaborador));
	}
}